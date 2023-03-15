package com.sebag.florent.data.entities

import com.sebag.florent.domain.models.CharacterModel
import com.squareup.moshi.Json

data class Response(
    @Json(name = "info")
    val info: ResponseInfoEntity,
    @Json(name = "results")
    val results: List<CharacterModel>
)

data class ResponseInfoEntity(
    @Json(name = "count")
    val count: Int,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "prev")
    val prev: String
)

data class PagedResponseEntity(
    @Json(name = "offset")  val offset : Int,
    @Json(name = "limit")   val limit : Int,
    @Json(name = "total")   val total : Int,
    @Json(name = "count")   val count : Int,
    @Json(name= "results")  val results : List<CharacterModel>
)
