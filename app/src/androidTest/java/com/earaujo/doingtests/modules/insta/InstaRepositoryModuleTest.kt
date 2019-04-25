package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.data.network.Network
import com.earaujo.doingtests.data.repository.InstaRepository
import org.mockito.Mockito.mock

class InstaRepositoryModuleTest : InstaRepositoryModule() {

    override fun provideInstaRepository(network: Network): InstaRepository {
        return mock(InstaRepository::class.java)
    }
}