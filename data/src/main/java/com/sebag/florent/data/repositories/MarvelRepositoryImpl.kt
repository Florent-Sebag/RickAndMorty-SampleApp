package com.sebag.florent.data.repositories

import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject constructor(
    private val service: MarvelApi
) : MarvelRepository {

    override fun fetchCharacterList(): Single<List<CharacterModel>> {

        return service.fetchCharacterListFromApi()
            .subscribeOn(Schedulers.io())
            .map { it.data.results }
    }
}