package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.earaujo.doingtests.annotations.DebugOpenClass
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource
import com.earaujo.doingtests.data.repository.insta.InstaRepository

@DebugOpenClass
class InstaViewModel(private val instaRepository: InstaRepository) : ViewModel() {

    private val searchRequest = MediatorLiveData<Unit>()

    val getData: LiveData<Resource<Insta>> = Transformations.switchMap(searchRequest) {
        instaRepository.getData()
    }

    fun reload() {
        this.searchRequest.value = Unit
    }
}