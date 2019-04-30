package com.earaujo.doingtests.data.model

data class Insta(val titleImageUrl: String,
                 val titleAuthorName: String,
                 val mainImageUrl: String,
                 val descAuthorComment: String,
                 val isSponsored: Boolean = false) {
}