package com.earaujo.doingtests.di

import com.earaujo.doingtests.car.Driver
import com.earaujo.doingtests.data.db.QuoteDao
import com.earaujo.doingtests.data.repository.QuoteRepository
import com.earaujo.doingtests.modules.DriverModule
import com.earaujo.doingtests.modules.quotes.DatabaseFakeModule
import com.earaujo.doingtests.modules.quotes.QuoteDaoModule
import com.earaujo.doingtests.modules.quotes.QuoteRepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class, DatabaseFakeModule::class, QuoteDaoModule::class, QuoteRepositoryModule::class])
interface AppComponent {

    fun getDriver(): Driver

    fun getQuotaDao(): QuoteDao

    fun getQuoteRepository(): QuoteRepository
}