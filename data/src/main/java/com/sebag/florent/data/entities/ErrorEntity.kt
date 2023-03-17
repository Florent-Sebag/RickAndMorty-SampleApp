package com.sebag.florent.data.entities

import com.squareup.moshi.Json

data class ErrorEntity(
    @Json(name = "error")
    val error: String
)