package com.johnyalam.copmoserandroid.data.remote.dto

import com.johnyalam.copmoserandroid.data.remote.dto.Stats


data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)