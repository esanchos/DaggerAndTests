package com.earaujo.doingtests.modules

import com.earaujo.doingtests.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DriverModule {

    @Provides
    @Singleton
    fun provideDriver(): Driver {
        return Driver();
    }
}