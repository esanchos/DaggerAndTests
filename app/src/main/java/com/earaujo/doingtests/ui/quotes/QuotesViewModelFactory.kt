package com.earaujo.doingtests.ui.quotes

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.earaujo.doingtests.data.repository.QuoteRepository
import com.earaujo.doingtests.di.PerActivity
import javax.inject.Inject

@PerActivity
class QuotesViewModelFactory @Inject constructor(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}