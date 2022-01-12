package com.sebag.florent.data.repositories

import com.sebag.florent.domain.repositories.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject constructor() : MarvelRepository {

    override fun fetchCharacterList(): String {
        return "hello from data"
    }
}