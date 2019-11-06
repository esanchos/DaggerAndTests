package com.earaujo.doingtests.ui.insta

import android.app.Application
import javax.inject.Inject

class MyClass @Inject constructor(private val app: Application) {

    fun getPackage() = app.packageName

}