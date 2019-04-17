package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.network.NetworkFakeImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NetworkFakeModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideDatabase(): Network {
        return NetworkFakeImpl()
    }
}