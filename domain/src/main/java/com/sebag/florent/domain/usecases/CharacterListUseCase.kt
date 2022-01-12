package com.sebag.florent.domain.usecases

import androidx.paging.PagingData
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterListUseCase
@Inject constructor(
    private val marvelRepository: MarvelRepository
){

    fun getCharacterList() : Single<List<CharacterModel>> = marvelRepository.fetchCharacterList()

    fun getPagingCharacterList() : Flowable<PagingData<CharacterModel>> = marvelRepository.retrieveCharacterList()

}