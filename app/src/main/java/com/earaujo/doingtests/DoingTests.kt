package com.earaujo.doingtests

import android.app.Application
import com.earaujo.doingtests.di.AppComponent
import com.earaujo.doingtests.di.DaggerAppComponent

class DoingTests: Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.create()
    }

    public fun getAppComponent(): AppComponent {
        return component
    }
}