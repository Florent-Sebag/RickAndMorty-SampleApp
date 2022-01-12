package com.sebag.florent.data.repositories

import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject constructor() : MarvelRepository {

    override fun fetchCharacterList(): Single<String> {
        return Single.create { emitter ->
            emitter.onSuccess("Hello from repository")
        }
    }
}