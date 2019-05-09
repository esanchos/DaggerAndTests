package com.earaujo.doingtests.data.repository.insta

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.db.insta.InstaDatabase
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.repository.AppExecutors
import com.earaujo.doingtests.data.repository.NetworkBoundResource
import com.earaujo.doingtests.data.repository.Resource

class InstaRepositoryImpl(
    private val appExecutors: AppExecutors,
    private val database: InstaDatabase,
    private val network: Network
): InstaRepository {

    override fun getData(): LiveData<Resource<Insta>> {
        return object : NetworkBoundResource<Insta, Insta>(appExecutors) {
            override fun saveCallResult(item: Insta) {
                database.instaDao.addInstaModel(item)
            }

            override fun shouldFetch(data: Insta?) = data == null

            override fun loadFromDb() = database.instaDao.getInstaModel()

            override fun createCall() = network.getData()
        }.asLiveData()
    }
}