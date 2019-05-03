package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.earaujo.doingtests.DoingTests
import com.earaujo.doingtests.R
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource
import com.earaujo.doingtests.data.repository.Status
import com.earaujo.doingtests.di.DaggerInstaActivityComponent
import kotlinx.android.synthetic.main.activity_insta.*
import javax.inject.Inject

class InstaActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: InstaViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta)

        DaggerInstaActivityComponent
            .builder()
            .appComponent((application as DoingTests).appComponent)
            .build()
            .inject(this)

        initializeUi()
    }

    private fun initializeUi() {
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(InstaViewModel::class.java)

        setImageHeigthSize()

        viewModel.getData().observe(this, Observer { insta ->
            insta?.let { populateUi(it) }
        })
    }

    private fun setImageHeigthSize() {
        iv_main_imagem.layoutParams.height = getDisplayWidth()
        iv_main_imagem.requestLayout()
    }

    private fun getDisplayWidth(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    private fun populateUi(resourceData: Resource<Insta>) {
        when (resourceData.status) {
            Status.LOADING -> {
                pb_loading.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
                pb_loading.visibility = View.GONE
                resourceData.data?.let {
                    tv_title_author_name.text = it.titleAuthorName
                    tv_desc_author_name.text = it.titleAuthorName
                    tv_desc_author_comment.text = it.descAuthorComment

                    tv_title_sponsored.visibility = if (it.isSponsored) View.VISIBLE else View.GONE

                    Glide.with(this)
                        .load(it.titleImageUrl)
                        .apply(RequestOptions.circleCropTransform())
                        .into(iv_title_author_image)

                    Glide.with(this)
                        .load(it.mainImageUrl)
                        .into(iv_main_imagem)
                }
            }
            Status.ERROR -> {
                pb_loading.visibility = View.GONE
            }
        }
    }
}