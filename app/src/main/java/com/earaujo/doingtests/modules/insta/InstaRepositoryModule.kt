package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.annotations.DebugOpenClass
import com.earaujo.doingtests.data.db.insta.InstaDatabase
import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.repository.AppExecutors
import com.earaujo.doingtests.data.repository.insta.InstaRepository
import com.earaujo.doingtests.data.repository.insta.InstaRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@DebugOpenClass
@Module
class InstaRepositoryModule {

    @Provides
    @Singleton
    fun provideInstaRepository(appExecutors: AppExecutors, database: InstaDatabase, network: Network): InstaRepository {
        return InstaRepositoryImpl(appExecutors, database, network)
    }
}