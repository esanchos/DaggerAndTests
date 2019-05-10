package com.earaujo.doingtests.di

import com.earaujo.doingtests.modules.AppModule
import com.earaujo.doingtests.modules.car.DriverModule
import com.earaujo.doingtests.modules.insta.InstaDatabaseFakeImplModule
import com.earaujo.doingtests.modules.insta.InstaRepositoryModule
import com.earaujo.doingtests.modules.insta.InstaViewModelModule
import com.earaujo.doingtests.modules.insta.NetworkFakeModule
import com.earaujo.doingtests.modules.quotes.DatabaseFakeModule
import com.earaujo.doingtests.modules.quotes.QuoteDaoModule
import com.earaujo.doingtests.modules.quotes.QuoteRepositoryModule
import com.earaujo.doingtests.ui.insta.InstaActivityTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DriverModule::class,
        DatabaseFakeModule::class,
        QuoteDaoModule::class,
        QuoteRepositoryModule::class,
        InstaRepositoryModule::class,
        NetworkFakeModule::class,
        InstaViewModelModule::class,
        InstaDatabaseFakeImplModule::class
    ]
)
interface AppComponentTest : AppComponent {
    fun inject(test: InstaActivityTest)
}