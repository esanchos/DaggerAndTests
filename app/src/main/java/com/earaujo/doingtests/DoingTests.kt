package com.earaujo.doingtests

import android.app.Application
import com.earaujo.doingtests.di.AppComponent
import com.earaujo.doingtests.di.DaggerAppComponent
import com.earaujo.doingtests.modules.AppModule

class DoingTests: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)
    }
}