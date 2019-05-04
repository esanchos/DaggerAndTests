package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.annotations.DebugOpenClass
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.ui.insta.InstaViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@DebugOpenClass
@Module
class InstaViewModelModule {

    @Provides
    @Singleton
    fun provideInstaViewModel(instaRepository: InstaRepository): InstaViewModel {
        return InstaViewModel(instaRepository)
    }
}