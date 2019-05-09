package com.earaujo.doingtests.data.db.insta

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.earaujo.doingtests.data.model.Insta

class InstaDaoFakeImpl: InstaDao {
    private var instaLocalData: Insta? = null

    override fun addInstaModel(instaModel: Insta) {
        instaLocalData = instaModel
    }

    override fun getInstaModel():LiveData<Insta> {
        return MutableLiveData<Insta>().apply { postValue(instaLocalData) }
    }

    override fun hasData(): Boolean {
        return (instaLocalData!=null)
    }
}