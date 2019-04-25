package com.earaujo.doingtests.modules.car

import com.earaujo.doingtests.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DriverModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideDriver(): Driver {
        return Driver();
    }
}