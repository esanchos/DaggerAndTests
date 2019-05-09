package com.earaujo.doingtests.modules.insta

import com.earaujo.doingtests.data.db.insta.InstaDatabase
import com.earaujo.doingtests.data.db.insta.InstaDatabaseFakeImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InstaDatabaseFakeImplModule {

    @Provides
    @Singleton
    fun provideInstaDatabase(): InstaDatabase {
        return InstaDatabaseFakeImpl()
    }
}