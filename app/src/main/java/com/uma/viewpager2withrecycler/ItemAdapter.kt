package com.uma.viewpager2withrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uma.viewpager2withrecycler.databinding.InflatePhotoItemBinding
import kotlinx.android.synthetic.main.inflate_photo_item.view.*

/**
 * Created by Umapathi on 2019-12-12.
 * Copyright Indyzen Inc, @2019
 */
class ItemAdapter(
    var ctx: Context,
    var list: ArrayList<ItemModel>,
    var recyclerViewItemClickListener: RecyclerViewItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var itemBinding: InflatePhotoItemBinding
    var currentPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        itemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.inflate_photo_item,
            parent,
            false
        )
        return ItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ItemViewHolder
        itemViewHolder.onBind(list[position])

        Glide.with(ctx).load(list[position].drawable).into(itemViewHolder.itemView.imgPhoto)

        // item click operation...
        itemViewHolder.itemView.imgPhoto.setOnClickListener {
            recyclerViewItemClickListener.performClick(position)
            updateBorder(position)
        }

        if (position == currentPosition) {1
            itemViewHolder.itemView.imgBorder.visibility = View.VISIBLE
        } else {
            itemViewHolder.itemView.imgBorder.visibility = View.GONE
        }
    }

    inner class ItemViewHolder(var inflatePhotoItemBinding: InflatePhotoItemBinding) : RecyclerView.ViewHolder(inflatePhotoItemBinding.root) {

        fun onBind(item : ItemModel){
            inflatePhotoItemBinding.itemBinding = item
        }

        /**
         * these lines for data binding with separate view holder....
         */
//        private var itemViewMoel: ItemViewModel? = null
//
//        fun onBind(item: ItemModel) {
//
//            itemViewMoel = ItemViewModel(item)
//
//            v.itemBinding = itemViewMoel
//
//            v.executePendingBindings()
//
//        }

    }

    /**
     * This method for update the item border....
     */
    fun updateBorder(position: Int) {
        currentPosition = position
        notifyDataSetChanged()
    }
}