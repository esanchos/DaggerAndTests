package com.earaujo.doingtests.data.network

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Insta

interface Network {
    fun getData(): LiveData<Insta>
}