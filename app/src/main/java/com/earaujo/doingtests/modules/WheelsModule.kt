package com.earaujo.doingtests.modules

import com.earaujo.doingtests.car.Rims
import com.earaujo.doingtests.car.Tires
import com.earaujo.doingtests.car.Wheels
import dagger.Module
import dagger.Provides

@Module
object WheelsModule {

    @Provides
    @JvmStatic
    internal fun provideRims(): Rims {
        return Rims()
    }

    @Provides
    @JvmStatic
    internal fun provideTires(): Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @Provides
    @JvmStatic
    internal fun provideWheels(rims: Rims, tires: Tires): Wheels {
        return Wheels(rims, tires)
    }
}