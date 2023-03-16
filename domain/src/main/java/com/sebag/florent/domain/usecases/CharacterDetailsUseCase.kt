package com.sebag.florent.domain.usecases

import com.sebag.florent.domain.models.CharacterModel
import io.reactivex.rxjava3.core.Single

abstract class CharacterDetailsUseCase {

    abstract fun getCharacterDetail(id: Int, position: Int) : Single<CharacterModel>
}