package com.earaujo.doingtests.modules.quotes

import com.earaujo.doingtests.data.db.QuoteDao
import com.earaujo.doingtests.data.repository.QuoteRepository
import com.earaujo.doingtests.data.repository.QuoteRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object QuoteRepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideQuoteRepository(quoteDao: QuoteDao): QuoteRepository {
        return QuoteRepositoryImpl(quoteDao)
    }
}