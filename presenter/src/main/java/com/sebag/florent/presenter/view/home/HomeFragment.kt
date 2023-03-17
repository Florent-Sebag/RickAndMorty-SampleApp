package com.sebag.florent.presenter.view.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebag.florent.presenter.R
import com.sebag.florent.presenter.databinding.FragmentHomeBinding
import com.sebag.florent.presenter.view.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {

    override fun layoutRes() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recycler.layoutManager = LinearLayoutManager(context)
        viewModel.launchPagingCharacterList(lifecycle)
    }
}