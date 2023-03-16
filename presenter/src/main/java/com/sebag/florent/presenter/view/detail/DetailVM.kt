package com.sebag.florent.presenter.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.usecases.CharacterDetailsUseCase
import com.sebag.florent.presenter.view.base.BaseVM
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class DetailVM
@Inject constructor(
    private val detailsUseCase: CharacterDetailsUseCase
): BaseVM() {

    private val _characterDetails = MutableLiveData<CharacterModel>()
    val characterDetails : LiveData<CharacterModel>
    get() = _characterDetails

    fun getCharacterDetails(id: Int, position: Int) {
        detailsUseCase.getCharacterDetail(id, position)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy (
                onSuccess = { _characterDetails.value = it },
                onError = { _onError.value = DETAILS_ERROR_MESSAGE }
            )
            .addToDisposable()
    }

    companion object {
        const val DETAILS_ERROR_MESSAGE = "Error from getting character details"
    }
}