package com.sebag.florent.presenter.view.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = CharacterAdapter()

        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter =  mAdapter

        viewModel.launchPagingCharacterList(lifecycle, mAdapter)
        observeError()
    }

    private fun observeError() {
        viewModel.onError.observe(viewLifecycleOwner, {
            showToast(it)
        })
    }
}