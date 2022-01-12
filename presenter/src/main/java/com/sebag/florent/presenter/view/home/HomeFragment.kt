package com.sebag.florent.presenter.view.home

import android.os.Bundle
import android.view.View
import com.sebag.florent.presenter.R
import com.sebag.florent.presenter.databinding.FragmentHomeBinding
import com.sebag.florent.presenter.view.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var viewModel : HomeVM

    override fun layoutRes() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel

        viewModel.launchFetchCharacterList()
    }
}