package com.sebag.florent.domain.models

data class CharacterModel(
    val id : Int,
    val name : String,
    val type : String,
    val image: String
)

data class Thumbnail(
    val path : String,
    val extension: String,
) {
    var concatedPath: String? = null
        get() {
            field = field ?:  "$path.$extension"
            return field
        }
}