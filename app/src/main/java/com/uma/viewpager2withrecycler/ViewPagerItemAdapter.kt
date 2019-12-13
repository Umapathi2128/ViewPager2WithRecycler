package com.uma.viewpager2withrecycler

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Umapathi on 2019-12-12.
 * Copyright Indyzen Inc, @2019
 */
class ViewPagerItemAdapter(var itemList : ArrayList<ItemModel> , fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = itemList.size

    override fun createFragment(position: Int): Fragment =
        ImagesFragment.newInstance(itemList[position].drawable,position)
}