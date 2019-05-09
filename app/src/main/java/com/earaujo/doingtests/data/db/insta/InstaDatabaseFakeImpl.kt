package com.earaujo.doingtests.data.db.insta

class InstaDatabaseFakeImpl: InstaDatabase {
    override val instaDao: InstaDao = InstaDaoFakeImpl()
}