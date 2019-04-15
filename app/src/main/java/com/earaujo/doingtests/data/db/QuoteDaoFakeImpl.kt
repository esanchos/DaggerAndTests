package com.earaujo.doingtests.data.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.earaujo.doingtests.data.model.Quote

class QuoteDaoFakeImpl : QuoteDao {

    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>
}