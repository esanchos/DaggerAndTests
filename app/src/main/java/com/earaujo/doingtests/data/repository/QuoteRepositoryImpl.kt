package com.earaujo.doingtests.data.repository

import com.earaujo.doingtests.data.db.QuoteDao
import com.earaujo.doingtests.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}