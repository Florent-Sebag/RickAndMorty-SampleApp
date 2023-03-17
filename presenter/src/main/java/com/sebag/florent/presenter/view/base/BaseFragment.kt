package com.sebag.florent.presenter.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.sebag.florent.presenter.HostActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, U: BaseVM> : Fragment() {

    @LayoutRes
    protected abstract fun layoutRes() : Int

    @Inject
    protected lateinit var viewModel : U

    protected lateinit var binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutRes(),
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    private fun observeViewModel() {
        viewModel.onError.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
        viewModel.showLoading.observe(viewLifecycleOwner) { showLoading ->
            if (showLoading)
                (activity as? HostActivity)?._showLoading?.value = View.VISIBLE
            else
                (activity as? HostActivity)?._showLoading?.value = View.INVISIBLE
        }
    }
}