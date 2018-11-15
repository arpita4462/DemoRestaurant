package com.gmediasolutions.demorestaurant.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import java.util.ArrayList
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import android.support.v7.widget.GridLayoutManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import android.widget.Toast
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import android.net.Uri
import android.util.Log
import com.gmediasolutions.demorestaurant.*
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection




class HomeFragment : Fragment() {

        private var sectionAdapter: SectionedRecyclerViewAdapter? = null
        var mActivity: MainActivity? = null
        private var sliderShow: SliderLayout? = null
        private var item1Layout: LinearLayout? = null
        private var item2Layout: LinearLayout? = null
        private var item3Layout: LinearLayout? = null
        private var item4Layout: LinearLayout? = null
        private var item5Layout: LinearLayout? = null
        private var item6Layout: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as MainActivity?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.home_fragment, container, false)
        inflateImageSlider(view)
        setupSectionRecyclerView(view)
        return view
    }



    private fun inflateImageSlider(view: View) {

        // Using Image Slider -----------------------------------------------------------------------
        sliderShow = view.findViewById(R.id.slider)
        //populating Image slider
        val sliderImages = ArrayList<String>()
        sliderImages.add("https://images.pexels.com/photos/972533/pexels-photo-972533.jpeg?auto=compress&cs=tinysrgb&h=350")
        sliderImages.add("https://images.pexels.com/photos/744780/pexels-photo-744780.jpeg?auto=compress&cs=tinysrgb&h=350")
        sliderImages.add("https://images.pexels.com/photos/878992/pexels-photo-878992.jpeg?auto=compress&cs=tinysrgb&h=350")
        sliderImages.add("https://images.pexels.com/photos/296888/pexels-photo-296888.jpeg?auto=compress&cs=tinysrgb&h=350")

        for (s in sliderImages) {
            val sliderView = DefaultSliderView(context)
            sliderView.image(s)
            sliderShow!!.addSlider(sliderView)
        }

        sliderShow!!.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom)

    }

    private fun setupSectionRecyclerView(view: View) {

//        val imageUrlUtils = ImageUrlUtils()
        sectionAdapter = SectionedRecyclerViewAdapter()

        sectionAdapter!!.addSection(ItemSection("Recommended", ImageUrlUtils.offersUrls))
        sectionAdapter!!.addSection(ItemSection("Featured Food", ImageUrlUtils.imageUrls))

        val recyclerView = view.findViewById(R.id.recyclerview_main) as RecyclerView

        val glm = GridLayoutManager(context, 2)
        glm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (sectionAdapter!!.getSectionItemViewType(position)) {
                    SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER -> return 2
                    else -> return 1
                }
            }
        }
        recyclerView.layoutManager = glm
        recyclerView.adapter = sectionAdapter
    }


     inner class HeaderViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

         val tvTitle: TextView
         val btnMore: Button

        init {

            tvTitle = view.findViewById<View>(R.id.tvTitle) as TextView
            btnMore = view.findViewById<View>(R.id.btnMore) as Button
        }
    }

     inner class ItemViewHolder internal constructor(private val rootView: View) : RecyclerView.ViewHolder(rootView) {
        val mImageView: SimpleDraweeView
        val mLayoutItem: LinearLayout

        init {
            mImageView = rootView.findViewById(R.id.image1) as SimpleDraweeView
            mLayoutItem = rootView.findViewById(R.id.layout_item) as LinearLayout
        }
    }

     inner class ItemSection internal constructor(internal var title: String, private val list: Array<String>) : StatelessSection(SectionParameters.builder()
            .itemResourceId(R.layout.list_item)
            .headerResourceId(R.layout.section_ex5_header)
            .build()) {

        override fun getContentItemsTotal(): Int {
            return 4
        }

        override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
            return ItemViewHolder(view)
        }

        override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val itemHolder = holder as ItemViewHolder

            val uri = Uri.parse(list[position])
            itemHolder.mImageView.setImageURI(uri)

            holder.mLayoutItem.setOnClickListener {
                Log.i("item_index",position.toString())
                val intent = Intent(ImageListFragment.mActivity, ItemDetailsActivity::class.java)
                intent.putExtra(ImageListFragment.STRING_IMAGE_URI, list[position])
                intent.putExtra(ImageListFragment.STRING_IMAGE_POSITION, position)
                ImageListFragment.mActivity!!.startActivity(intent)
            }


        }

        override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
            return HeaderViewHolder(view)
        }

        override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
            val headerHolder = holder as HeaderViewHolder?

            headerHolder!!.tvTitle.text = title

            headerHolder.btnMore.setOnClickListener {
                startActivity(Intent(ImageListFragment.mActivity, EmptyActivity::class.java))
                Toast.makeText(context, String.format("More Button Click.", title),
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}
