package com.earaujo.doingtests.ui.quotes

import android.arch.lifecycle.ViewModel
import com.earaujo.doingtests.data.model.Quote
import com.earaujo.doingtests.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}