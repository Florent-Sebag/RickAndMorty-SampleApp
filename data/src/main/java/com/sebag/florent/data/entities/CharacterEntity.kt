package com.sebag.florent.data.entities

import com.squareup.moshi.Json

data class CharacterEntity(
    @Json(name = "id")
    val id : Int,
    @Json(name = "name")
    val name : String,
    @Json(name = "species")
    val species : String,
    @Json(name = "image")
    val image: String
)