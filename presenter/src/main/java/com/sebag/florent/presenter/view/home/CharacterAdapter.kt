package com.sebag.florent.presenter.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.presenter.databinding.ItemCharacterBinding

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (url != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available") {
        Glide.with(view.context).load(url).into(view)
    }
}

class CharacterAdapter :
    PagingDataAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel) {
            binding.character = item
            binding.viewholder = this
        }

        fun onClickItem(id: Int) {
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel) =
            oldItem == newItem
    }
}