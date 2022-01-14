package com.sebag.florent.presenter.view.home

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LoadState
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import javax.inject.Inject

class HomeVM
@Inject constructor(
    private val characterListUseCase: CharacterListUseCase
): BaseVM() {

    private val _onError = MutableLiveData<String>()
    val onError : LiveData<String>
        get() = _onError

    fun launchPagingCharacterList(lifecycle: Lifecycle, characterAdapter: CharacterAdapter) {
        characterListUseCase.getPagingCharacterList()
            .subscribe { data ->
            characterAdapter.submitData(lifecycle, data)
            characterAdapter.addLoadStateListener {
                if (it.refresh is LoadState.Error)
                    _onError.value = (it.refresh as LoadState.Error).error.message
            }
        }.addToDisposable()
    }
}