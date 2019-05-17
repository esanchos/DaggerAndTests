package com.earaujo.doingtests.modules.insta

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.earaujo.doingtests.di.ViewModelKey
import com.earaujo.doingtests.ui.insta.DaggerViewModelFactory
import com.earaujo.doingtests.ui.insta.InstaViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class InstaViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(InstaViewModel::class)
    abstract fun bindRepoViewModel(instaViewModel: InstaViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}