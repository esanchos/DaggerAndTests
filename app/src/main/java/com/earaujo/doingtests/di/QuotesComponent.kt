package com.earaujo.doingtests.di

import com.earaujo.doingtests.ui.quotes.QuotesActivity
import com.earaujo.doingtests.ui.quotes.QuotesViewModelFactory
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class])
interface QuotesComponent {

    val viewModelFactory: QuotesViewModelFactory

    fun inject(quotesActivity: QuotesActivity)
}