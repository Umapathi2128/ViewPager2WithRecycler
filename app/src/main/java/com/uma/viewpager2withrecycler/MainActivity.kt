package com.uma.viewpager2withrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.uma.viewpager2withrecycler.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewItemClickListener {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var adapter: ItemAdapter
    lateinit var itemList: ArrayList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val mainModel = ViewModelProviders.of(this).get(MainModel::class.java)
        val mainVM = MainVM(this)
        mainBinding.mainBinding = mainVM

        itemList = ArrayList()
        addItemsToList()
        adapter = ItemAdapter(this, itemList, this)

        initHorizontalRecyclerView()
        settingViewPagerAdapter()
        viewPagerChangeListener()
    }

    /**
     * This method for initiating recycler view setting layout manager...
     */
    private fun initHorizontalRecyclerView() {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        itemRecycler.layoutManager = layoutManager
        itemRecycler.adapter = adapter
    }
    /**
     * This method for initiating Viewpager2 and adapter...
     */
    private fun settingViewPagerAdapter() {
        val viewPagerItemAdapter = ViewPagerItemAdapter(itemList, this)
        viewPager2.adapter = viewPagerItemAdapter
    }

    /**
     * Setting on page change listener for viewpager2...
     * updating recyclerView position....
     */
    private fun viewPagerChangeListener() {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapter.updateBorder(position)
                itemRecycler.scrollToPosition(position)
                txtImageName.text = itemList[position].text
            }

        })
    }

    private fun addItemsToList() {
        itemList.add(
            ItemModel(
                "First Item😀",
                R.drawable.a
            )
        )
        itemList.add(
            ItemModel(
                "Second Item😀",
                R.drawable.f
            )
        )
        itemList.add(
            ItemModel(
                "Third Item😀",
                R.drawable.b
            )
        )
        itemList.add(
            ItemModel(
                "Fourth Item😀",
                R.drawable.c
            )
        )
        itemList.add(
            ItemModel(
                "Fifth Item😀",
                R.drawable.d
            )
        )
        itemList.add(
            ItemModel(
                "Sixth Item😀",
                R.drawable.e
            )
        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/Children_holding_hands_together.png?alt=media&token=97185e03-60c1-43d1-b67e-85410fb66abf",
//                R.drawable.f
//            )
//        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/GET_TOGETHER-300x148.png?alt=media&token=ca9e9635-40a9-4e9c-a4d5-011a8b526ec4",
//                R.drawable.a
//
//            )
//        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/GET_TOGETHER-300x148.png?alt=media&token=ca9e9635-40a9-4e9c-a4d5-011a8b526ec4",
//                R.drawable.b
//
//            )
//        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/GET_TOGETHER-300x148.png?alt=media&token=ca9e9635-40a9-4e9c-a4d5-011a8b526ec4",
//                R.drawable.c
//
//            )
//        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/GET_TOGETHER-300x148.png?alt=media&token=ca9e9635-40a9-4e9c-a4d5-011a8b526ec4",
//                R.drawable.d
//
//            )
//        )
//        itemList.add(
//            ItemModel(
//                this,
//                "https://firebasestorage.googleapis.com/v0/b/friends-531ea.appspot.com/o/GET_TOGETHER-300x148.png?alt=media&token=ca9e9635-40a9-4e9c-a4d5-011a8b526ec4",
//                R.drawable.e
//
//            )
//        )
    }

    override fun performClick(position: Int) {
        viewPager2.currentItem = position
        txtImageName.text = itemList[position].text
    }
}
