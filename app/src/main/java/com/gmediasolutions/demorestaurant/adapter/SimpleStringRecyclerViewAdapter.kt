package com.gmediasolutions.demorestaurant.adapter

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.gmediasolutions.demorestaurant.ImageUrlUtils
import com.gmediasolutions.demorestaurant.ItemDetailsActivity
import com.gmediasolutions.demorestaurant.R
import com.gmediasolutions.demorestaurant.fragment.ImageListFragment

class SimpleStringRecyclerViewAdapter(private val mRecyclerView: RecyclerView, private val mValues: Array<String>) : RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        if (holder.mImageView.getController() != null) {
            holder.mImageView.getController()!!.onDetach()
        }
        if (holder.mImageView.getTopLevelDrawable() != null) {
            holder.mImageView.getTopLevelDrawable()!!.setCallback(null)
            //                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /* FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) holder.mImageView.getLayoutParams();
        if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            layoutParams.height = 200;
        } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            layoutParams.height = 600;
        } else {
            layoutParams.height = 800;
        }*/
        val uri = Uri.parse(mValues[position])
        holder.mImageView.setImageURI(uri)
        holder.mLayoutItem.setOnClickListener {
            Log.i("item_index",position.toString())
            val intent = Intent(ImageListFragment.mActivity, ItemDetailsActivity::class.java)
            intent.putExtra(ImageListFragment.STRING_IMAGE_URI, mValues[position])
            intent.putExtra(ImageListFragment.STRING_IMAGE_POSITION, position)
            ImageListFragment.mActivity!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mImageView: SimpleDraweeView
        val mLayoutItem: LinearLayout
        init {
            mImageView = mView.findViewById(R.id.image1) as SimpleDraweeView
            mLayoutItem = mView.findViewById(R.id.layout_item) as LinearLayout

        }
    }

}
