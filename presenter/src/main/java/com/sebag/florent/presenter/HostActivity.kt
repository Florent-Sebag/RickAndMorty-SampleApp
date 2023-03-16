package com.sebag.florent.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sebag.florent.presenter.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityHostBinding

    val _showLoading = MutableLiveData<Int>()
    val showLoading : LiveData<Int>
        get() = _showLoading


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_host)
        binding.lifecycleOwner = this
        binding.activity = this
    }
}