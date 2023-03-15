package com.sebag.florent.data.entities

import com.sebag.florent.domain.models.CharacterModel
import com.squareup.moshi.Json

data class ResponseEntity(
    @Json(name = "info")
    val info: InfoEntity,
    @Json(name = "results")
    val results: List<CharacterModel>
)
