package com.sebag.florent.presenter.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.presenter.databinding.ItemCharacterBinding
import com.sebag.florent.presenter.view.home.HomeFragmentDirections
import javax.inject.Inject

class CharacterAdapter @Inject constructor() :
    PagingDataAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel) {
            binding.character = item
            binding.viewholder = this
        }

        fun onClickItem(id: Int) {
            val direction = HomeFragmentDirections.goToDetail(id, layoutPosition)
            itemView.findNavController().navigate(direction)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel) =
            oldItem == newItem
    }
}