package com.sebag.florent.domain.usecases

import androidx.paging.PagingData
import com.sebag.florent.domain.models.CharacterModel
import io.reactivex.rxjava3.core.Flowable

abstract class CharacterListUseCase {

    abstract fun getPagingCharacterList() : Flowable<PagingData<CharacterModel>>
}