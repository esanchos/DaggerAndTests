package com.earaujo.doingtests.data.db

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}