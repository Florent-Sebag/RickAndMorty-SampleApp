package com.sebag.florent.presenter.view.home

import com.sebag.florent.presenter.R
import com.sebag.florent.presenter.view.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModel : HomeVM

    override fun layoutRes() = R.layout.fragment_home

}