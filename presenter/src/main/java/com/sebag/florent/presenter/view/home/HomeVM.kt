package com.sebag.florent.presenter.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import javax.inject.Inject

class HomeVM
@Inject constructor(
    private val characterListUseCase: CharacterListUseCase
): BaseVM() {

    val tmp = "hello from databind"

    private val _characterList = MutableLiveData<String>()
    val characterList : LiveData<String>
        get() = _characterList

    fun launchFetchCharacterList() {
        _characterList.value = characterListUseCase.getCharacterList()
    }
}