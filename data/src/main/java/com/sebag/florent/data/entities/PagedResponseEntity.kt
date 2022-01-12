package com.sebag.florent.data.entities

import com.squareup.moshi.Json

data class Response(
    @Json(name = "data")
    val pagedResponse: PagedResponseEntity
)

data class PagedResponseEntity(
    @Json(name = "offset")  val offset : Int,
    @Json(name = "limit")   val limit : Int,
    @Json(name = "total")   val total : Int,
    @Json(name = "count")   val count : Int,
    @Json(name="results")   val results:List<CharacterEntity>
)

data class CharacterEntity(
    @Json(name = "id")          val id : Int,
    @Json(name = "name")        val name : String,
    @Json(name = "description") val description : String
)