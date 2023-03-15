package com.sebag.florent.data.entities

import com.squareup.moshi.Json

data class InfoEntity(
    @Json(name = "count")
    val count: Int,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "prev")
    val prev: String
)