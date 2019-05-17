package com.earaujo.doingtests.di

import android.app.Application
import com.earaujo.doingtests.DoingTests
import com.earaujo.doingtests.car.Driver
import com.earaujo.doingtests.data.repository.QuoteRepository
import com.earaujo.doingtests.modules.car.DriverModule
import com.earaujo.doingtests.modules.insta.*
import com.earaujo.doingtests.modules.quotes.DatabaseFakeModule
import com.earaujo.doingtests.modules.quotes.QuoteDaoModule
import com.earaujo.doingtests.modules.quotes.QuoteRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DriverModule::class,
        DatabaseFakeModule::class,
        QuoteDaoModule::class,
        QuoteRepositoryModule::class,
        InstaRepositoryModule::class,
        NetworkFakeModule::class,
        InstaDatabaseFakeImplModule::class,
        InstaViewModelFactoryModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {

    fun getDriver(): Driver

    fun getQuoteRepository(): QuoteRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: DoingTests)
}