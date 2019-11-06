package com.earaujo.doingtests

import android.app.Application
import com.earaujo.doingtests.di.AppComponent
import com.earaujo.doingtests.di.DaggerAppComponent
import com.earaujo.doingtests.modules.quotes.AppModule

class DoingTests: Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getAppComponent(): AppComponent {
        return component
    }
}