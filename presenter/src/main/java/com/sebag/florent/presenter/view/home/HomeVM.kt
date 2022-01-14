package com.sebag.florent.presenter.view.home

import androidx.lifecycle.Lifecycle
import androidx.paging.LoadState
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import com.sebag.florent.presenter.view.home.adapter.CharacterAdapter
import javax.inject.Inject

class HomeVM
@Inject constructor(
    private val characterListUseCase: CharacterListUseCase,
    val characterAdapter: CharacterAdapter
): BaseVM() {

    fun launchPagingCharacterList(lifecycle: Lifecycle) {
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