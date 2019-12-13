package com.uma.viewpager2withrecycler.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**
 * Created by Umapathi on 2019-12-12.
 * Copyright Indyzen Inc, @2019
 */
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, img: Any) {
    Glide.with(view.context)
        .load(img)
        .into(view)


}


