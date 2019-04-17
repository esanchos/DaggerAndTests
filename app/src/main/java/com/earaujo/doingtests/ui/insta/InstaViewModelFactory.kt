package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.di.PerActivity
import javax.inject.Inject

@PerActivity
class InstaViewModelFactory @Inject constructor(private val instaRepository: InstaRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(instaRepository) as T
    }
}