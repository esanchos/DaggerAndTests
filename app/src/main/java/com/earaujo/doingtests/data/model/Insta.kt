package com.earaujo.doingtests.data.model

import com.earaujo.doingtests.annotations.DebugOpenClass

@DebugOpenClass
data class Insta(val titleImageUrl: String,
                 val titleAuthorName: String,
                 val mainImageUrl: String,
                 val descAuthorComment: String,
                 val isSponsored: Boolean = false) {
}