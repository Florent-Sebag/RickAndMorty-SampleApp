package com.sebag.florent.data.api

import com.sebag.florent.data.entities.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    fun fetchCharacterListFromApi(@Query("offset") offset: Int) : Single<Response>

    @GET("characters/{id}")
    fun fetchCharacterDetail(@Path("id") id: Int) : Single<Response>
}