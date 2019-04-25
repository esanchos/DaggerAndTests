package com.earaujo.doingtests.modules

import com.earaujo.doingtests.DoingTests
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: DoingTests) {
    @Provides
    @Singleton
    fun provideApp(): DoingTests = app
}