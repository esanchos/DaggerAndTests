package com.earaujo.doingtests.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource
import com.earaujo.doingtests.data.repository.Status
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkFakeImpl : Network {

    private val data = MutableLiveData<Resource<Insta>>()

    override fun getData(): LiveData<Resource<Insta>> {
        GlobalScope.launch {
            val instaData = Insta(
                "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
                "eduardoaraujo",
                "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
                "Este é uma foto de praia",
                true
            )
            delay(1000)
            data.postValue(Resource(Status.SUCCESS, instaData))
        }
        data.value = Resource(Status.LOADING)
        return data
    }
}