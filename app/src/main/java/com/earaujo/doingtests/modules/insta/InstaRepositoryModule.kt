package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.data.repository.InstaRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object InstaRepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideInstaRepository(network: Network): InstaRepository {
        return InstaRepositoryImpl(network)
    }
}