package com.earaujo.doingtests.modules.quotes

import com.earaujo.doingtests.data.db.Database
import com.earaujo.doingtests.data.db.DatabaseFakeImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseFakeModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideDatabase(): Database {
        return DatabaseFakeImpl()
    }
}