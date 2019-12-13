package com.uma.viewpager2withrecycler

import androidx.databinding.ObservableField

/**
 * Created by Umapathi on 2019-12-13.
 * Copyright Indyzen Inc, @2019
 */
class ItemViewModel(item: ItemModel) {
    var img: ObservableField<Int> = ObservableField(item.drawable)
}