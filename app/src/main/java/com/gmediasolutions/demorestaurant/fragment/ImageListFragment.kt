package com.gmediasolutions.demorestaurant.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmediasolutions.demorestaurant.ImageUrlUtils
import com.gmediasolutions.demorestaurant.MainActivity
import com.gmediasolutions.demorestaurant.R
import com.gmediasolutions.demorestaurant.adapter.SimpleStringRecyclerViewAdapter


class ImageListFragment : Fragment() {

    companion object {

        val STRING_IMAGE_URI = "ImageUri"
        val STRING_IMAGE_POSITION = "ImagePosition"
        var mActivity: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as MainActivity?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rv = inflater.inflate(R.layout.layout_recylerview_list, container, false) as RecyclerView
        setupRecyclerView(rv)
        return rv
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        /*  if (ImageListFragment.this.getArguments().getInt("type") == 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        } else if (ImageListFragment.this.getArguments().getInt("type") == 2) {
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        }*/
//        val imageUrlUtils = ImageUrlUtils()
        var items: Array<String>?
        if (this@ImageListFragment.arguments!!.getInt("type") == 1) {
            items = ImageUrlUtils.offersUrls
        } else if (this@ImageListFragment.arguments!!.getInt("type") == 2) {
            items = ImageUrlUtils.StarterUrls
        } else if (this@ImageListFragment.arguments!!.getInt("type") == 3) {
            items = ImageUrlUtils.southIndianUrls
        } else if (this@ImageListFragment.arguments!!.getInt("type") == 4) {
            items = ImageUrlUtils.northIndianUrls
        } else if (this@ImageListFragment.arguments!!.getInt("type") == 5) {
            items = ImageUrlUtils.dessertsUrls
        } else  if (this@ImageListFragment.arguments!!.getInt("type") == 6) {
            items = ImageUrlUtils.drinksUrls
        } else {
            items = ImageUrlUtils.imageUrls
        }
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = SimpleStringRecyclerViewAdapter(recyclerView, items)
    }



}
