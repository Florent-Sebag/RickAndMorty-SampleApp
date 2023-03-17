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

    private val _showLoading = MutableLiveData(false)
    val showLoading : LiveData<Boolean>
        get() = _showLoading

    protected fun showLoading() {
        _showLoading.value = true
    }

    protected fun hideLoading() {
        _showLoading.value = false
    }

    fun updateLoadingVisibility(isVisible: Boolean) {
        _showLoading.value = isVisible
    }

    protected fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}