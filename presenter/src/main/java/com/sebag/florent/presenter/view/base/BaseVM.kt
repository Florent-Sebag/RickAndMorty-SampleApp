package com.sebag.florent.presenter.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseVM : ViewModel(){

    private var compositeDisposable = CompositeDisposable()

    protected val _onError = MutableLiveData<String>()
    val onError : LiveData<String>
        get() = _onError

    protected val _showLoading = MutableLiveData<Boolean>()
    val showLoading : LiveData<Boolean>
        get() = _showLoading

    protected fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}