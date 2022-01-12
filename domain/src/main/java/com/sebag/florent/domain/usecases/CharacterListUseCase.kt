package com.sebag.florent.domain.usecases

import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterListUseCase
@Inject constructor(
    private val marvelRepository: MarvelRepository
){

    fun getCharacterList() : Single<String> = marvelRepository.fetchCharacterList()

}