package com.sebag.florent.domain.usecases

import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterDetailsUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository
){

    fun getCharacterDetail(id: Int, position: Int) : Single<CharacterModel> =
        marvelRepository.retrieveCharacterDetails(id, position)
}