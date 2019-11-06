package com.earaujo.doingtests.modules.quotes

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    @Inject
    internal fun provideApplication(): Application {
        return app
    }
}