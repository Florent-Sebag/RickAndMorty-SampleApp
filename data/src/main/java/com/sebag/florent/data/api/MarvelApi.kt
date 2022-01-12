package com.sebag.florent.data.api

import com.sebag.florent.data.entities.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MarvelApi {

    @GET("characters")
    fun fetchCharacterListFromApi() : Single<Response>
}