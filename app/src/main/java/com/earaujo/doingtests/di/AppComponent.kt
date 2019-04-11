package com.earaujo.doingtests.di

import com.earaujo.doingtests.car.Driver
import com.earaujo.doingtests.modules.DriverModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {

    fun getDriver(): Driver
}