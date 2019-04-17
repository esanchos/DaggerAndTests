package com.earaujo.doingtests.di

import com.earaujo.doingtests.ui.insta.InstaActivity
import com.earaujo.doingtests.ui.insta.InstaViewModelFactory
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class])
interface InstaActivityComponent {

    val viewModelFactory: InstaViewModelFactory

    fun inject(instaActivity: InstaActivity)
}