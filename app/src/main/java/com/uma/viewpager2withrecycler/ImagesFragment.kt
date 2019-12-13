package com.uma.viewpager2withrecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.images_fragment.*

/**
 * Created by Umapathi on 2019-12-12.
 * Copyright Indyzen Inc, @2019
 */
class ImagesFragment : Fragment() {

    var url  = 0
    var position = -1
//    val KEY_ITEM_NUMBER = "number"
//    val KEY_ITEM_URl : String = "item"


    /**
     * HERE we are setting the arguments
     * new instance in companion object so it will call before the fragment on create
     * The new instance called from ViewPagerItemAdapter
     */
    companion object {
        val KEY_ITEM_NUMBER = "number"
        val KEY_ITEM_URl = "item"

        fun newInstance(item: Int, position: Int): ImagesFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_ITEM_NUMBER, position)
            bundle.putInt(KEY_ITEM_URl, item)
//            bundle.putIntegerArrayList(KEY_ITEM_NUMBER, list)
            val fragment = ImagesFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            url = arguments?.getInt(KEY_ITEM_URl)!!
            position = (arguments?.get(KEY_ITEM_NUMBER) as Int?)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.images_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        /**
         * setting image to imageView with the help of GLIDE...
         */
        context?.let { Glide.with(it).load(url).into(imageFragment) }
    }
}