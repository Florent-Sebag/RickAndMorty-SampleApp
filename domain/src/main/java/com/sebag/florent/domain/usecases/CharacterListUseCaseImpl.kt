package com.sebag.florent.domain.usecases

import androidx.paging.PagingData
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.RickAndMortyRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CharacterListUseCaseImpl
@Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) : CharacterListUseCase() {

    override fun getPagingCharacterList() : Flowable<PagingData<CharacterModel>> =
        rickAndMortyRepository.retrieveCharacterList()
}