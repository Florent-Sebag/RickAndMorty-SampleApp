package com.sebag.florent.presenter.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class HomeVM
@Inject constructor(
    private val characterListUseCase: CharacterListUseCase
): BaseVM() {

    private val _characterList = MutableLiveData<String>()
    val characterList : LiveData<String>
        get() = _characterList

    fun launchFetchCharacterList() {
        characterListUseCase.getCharacterList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { _characterList.value = it },
                onError = { }
            )
            .addToDisposable()
    }
}