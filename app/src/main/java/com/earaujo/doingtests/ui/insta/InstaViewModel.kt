package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.ViewModel
import com.earaujo.doingtests.annotations.DebugOpenClass
import com.earaujo.doingtests.data.repository.InstaRepository

@DebugOpenClass
class InstaViewModel(private val instaRepository: InstaRepository) : ViewModel() {

    fun getData() = instaRepository.getData()
}