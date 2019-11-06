package com.earaujo.doingtests.ui.quotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.earaujo.doingtests.DoingTests
import com.earaujo.doingtests.R
import com.earaujo.doingtests.data.model.Quote
import com.earaujo.doingtests.di.DaggerQuotesComponent
import com.earaujo.doingtests.ui.insta.MyClass
import kotlinx.android.synthetic.main.activity_quotes.*
import javax.inject.Inject

class QuotesActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: QuotesViewModelFactory

    @Inject
    lateinit var myClass: MyClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        DaggerQuotesComponent.builder().appComponent((application as DoingTests).getAppComponent()).build().inject(this)

        initializeUi()

        Log.d("NUNES", "omg $viewModelFactory")
    }

    private fun initializeUi() {
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes?.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

        editText_quote.setText(myClass.getPackage())
    }
}