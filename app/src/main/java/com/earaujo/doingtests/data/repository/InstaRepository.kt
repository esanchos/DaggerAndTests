package com.earaujo.doingtests.data.repository

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Insta

interface InstaRepository {
    fun getData(): LiveData<Resource<Insta>>
}