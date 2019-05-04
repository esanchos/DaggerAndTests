package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.annotations.DebugOpenClass
import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.data.repository.InstaRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@DebugOpenClass
@Module
class InstaRepositoryModule {

    @Provides
    @Singleton
    fun provideInstaRepository(network: Network): InstaRepository {
        return InstaRepositoryImpl(network)
    }
}