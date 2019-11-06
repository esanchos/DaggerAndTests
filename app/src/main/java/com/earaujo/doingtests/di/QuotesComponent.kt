package com.earaujo.doingtests.di

import com.earaujo.doingtests.ui.insta.MyClass
import com.earaujo.doingtests.ui.quotes.QuotesActivity
import com.earaujo.doingtests.ui.quotes.QuotesViewModelFactory
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class])
interface QuotesComponent {

    val myClass: MyClass

    val viewModelFactory: QuotesViewModelFactory

    fun inject(quotesActivity: QuotesActivity)

}