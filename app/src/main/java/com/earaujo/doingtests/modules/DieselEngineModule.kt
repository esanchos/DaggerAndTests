package com.earaujo.doingtests.modules

import com.earaujo.doingtests.car.DieselEngine
import com.earaujo.doingtests.car.Engine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule(private val horsePower: Int) {

    @Provides
    fun provideEngine(): Engine {
        return DieselEngine(horsePower)
    }
}