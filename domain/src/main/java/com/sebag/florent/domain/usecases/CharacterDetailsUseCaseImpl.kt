package com.sebag.florent.domain.usecases

import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.RickAndMortyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterDetailsUseCaseImpl
@Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) : CharacterDetailsUseCase() {

    override fun getCharacterDetail(id: Int, position: Int) : Single<CharacterModel> =
        rickAndMortyRepository.retrieveCharacterDetails(id, position)
}