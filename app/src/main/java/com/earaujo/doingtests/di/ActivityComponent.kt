package com.earaujo.doingtests.di

import com.earaujo.doingtests.MainActivity
import com.earaujo.doingtests.car.Car
import com.earaujo.doingtests.modules.PetrolEngineModule
import com.earaujo.doingtests.modules.WheelsModule
import dagger.Component
import dagger.BindsInstance
import javax.inject.Named

@PerActivity
@Component(dependencies = [AppComponent::class],modules = [WheelsModule::class, PetrolEngineModule::class])
interface ActivityComponent {

    val car: Car

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun horsePower(@Named("horse power") horsePower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engine capacity") engineCapacity: Int): Builder

        fun appComponent(component: AppComponent): Builder

        fun build(): ActivityComponent
    }
}