package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.ViewModel
import com.earaujo.doingtests.data.repository.InstaRepository

class InstaViewModel(private val instaRepository: InstaRepository) : ViewModel() {

    fun getData() = instaRepository.getData()
}