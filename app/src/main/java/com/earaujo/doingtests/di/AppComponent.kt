package com.earaujo.doingtests.di

import android.app.Application
import com.earaujo.doingtests.car.Driver
import com.earaujo.doingtests.data.db.QuoteDao
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.data.repository.QuoteRepository
import com.earaujo.doingtests.modules.AppModule
import com.earaujo.doingtests.modules.car.DriverModule
import com.earaujo.doingtests.modules.insta.InstaRepositoryModule
import com.earaujo.doingtests.modules.insta.NetworkFakeModule
import com.earaujo.doingtests.modules.quotes.DatabaseFakeModule
import com.earaujo.doingtests.modules.quotes.QuoteDaoModule
import com.earaujo.doingtests.modules.quotes.QuoteRepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DriverModule::class,
    DatabaseFakeModule::class,
    QuoteDaoModule::class,
    QuoteRepositoryModule::class,
    InstaRepositoryModule::class,
    NetworkFakeModule::class
])
interface AppComponent {

    fun getDriver(): Driver

    fun getQuotaDao(): QuoteDao

    fun getQuoteRepository(): QuoteRepository

    fun getInstaRepository(): InstaRepository

    fun inject(app: Application)
}