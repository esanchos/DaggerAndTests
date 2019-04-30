package com.earaujo.doingtests.data.network

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource

interface Network {
    fun getData(): LiveData<Resource<Insta>>
}