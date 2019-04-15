package com.earaujo.doingtests.modules.quotes

import com.earaujo.doingtests.data.db.Database
import com.earaujo.doingtests.data.db.QuoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class QuoteDaoModule {

    @Provides
    @Singleton
    @Inject
    internal fun provideQuoteDao(database: Database): QuoteDao {
        return database.quoteDao
    }
}