package com.sebag.florent.domain.usecases

import androidx.paging.PagingData
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CharacterListUseCaseImpl
@Inject constructor(
    private val marvelRepository: MarvelRepository
) : CharacterListUseCase() {

    override fun getPagingCharacterList() : Flowable<PagingData<CharacterModel>> =
        marvelRepository.retrieveCharacterList()
}