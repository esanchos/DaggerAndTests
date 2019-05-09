package com.earaujo.doingtests.data.db.insta

import android.arch.lifecycle.LiveData
import com.earaujo.doingtests.data.model.Insta

interface InstaDao {
    fun addInstaModel(instaModel: Insta)
    fun getInstaModel(): LiveData<Insta>
    fun hasData(): Boolean
}