package com.sebag.florent.presenter.view.home.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (url != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available") {
        Glide.with(view.context).load(url).into(view)
    }
}