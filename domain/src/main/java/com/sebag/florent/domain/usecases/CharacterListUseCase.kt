package com.sebag.florent.domain.usecases

import com.sebag.florent.domain.repositories.MarvelRepository
import javax.inject.Inject

class CharacterListUseCase
@Inject constructor(
    private val marvelRepository: MarvelRepository
){

    fun getCharacterList() : String = marvelRepository.fetchCharacterList()

}