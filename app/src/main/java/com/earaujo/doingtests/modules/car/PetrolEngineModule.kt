package com.earaujo.doingtests.modules.car

import com.earaujo.doingtests.car.Engine
import com.earaujo.doingtests.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun bindEngine(engine: PetrolEngine): Engine
}