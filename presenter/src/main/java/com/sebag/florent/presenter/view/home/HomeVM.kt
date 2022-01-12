package com.sebag.florent.presenter.view.home

import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import javax.inject.Inject

class HomeVM
@Inject constructor(
    private val characterListUseCase: CharacterListUseCase
): BaseVM() {

    val tmp = "hello from databind"
    val characterList = characterListUseCase.getCharacterList()

    fun launchFetchCharacterList() {
        //characterList = characterListUseCase.getCharacterList()
    }
}