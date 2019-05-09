package com.earaujo.doingtests.data.repository.insta

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource

interface InstaRepository {
    fun getData(): LiveData<Resource<Insta>>
}