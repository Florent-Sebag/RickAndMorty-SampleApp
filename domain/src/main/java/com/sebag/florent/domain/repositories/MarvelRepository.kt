package com.sebag.florent.domain.repositories

import io.reactivex.rxjava3.core.Single

interface MarvelRepository {

    fun fetchCharacterList() : Single<String>
}