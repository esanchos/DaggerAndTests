package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.data.repository.insta.InstaRepository
import com.earaujo.doingtests.ui.insta.InstaViewModel
import org.mockito.Mockito.mock

class InstaViewModelModuleTest : InstaViewModelModule() {

    override fun provideInstaViewModel(instaRepository: InstaRepository): InstaViewModel {
        return mock(InstaViewModel::class.java)
    }
}