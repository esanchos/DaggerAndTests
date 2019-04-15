package com.earaujo.doingtests.data.repository

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}