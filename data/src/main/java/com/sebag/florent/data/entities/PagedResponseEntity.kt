package com.sebag.florent.data.entities

import com.sebag.florent.domain.models.CharacterModel
import com.squareup.moshi.Json

data class Response(
    @Json(name = "status")
    val status: String,
    @Json(name = "data")
    val data: PagedResponseEntity
)

data class PagedResponseEntity(
    @Json(name = "offset")  val offset : Int,
    @Json(name = "limit")   val limit : Int,
    @Json(name = "total")   val total : Int,
    @Json(name = "count")   val count : Int,
    @Json(name= "results")  val results : List<CharacterModel>
)
