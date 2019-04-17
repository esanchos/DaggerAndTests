package com.earaujo.doingtests.data.repository

import com.earaujo.doingtests.data.network.Network

class InstaRepositoryImpl(private val network: Network): InstaRepository {
    override fun getData() = network.getData()
}