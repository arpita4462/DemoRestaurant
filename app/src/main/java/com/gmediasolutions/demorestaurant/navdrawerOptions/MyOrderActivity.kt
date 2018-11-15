package com.gmediasolutions.demorestaurant.navdrawerOptions

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.gmediasolutions.demorestaurant.*
import com.gmediasolutions.demorestaurant.alert.NetworkStateReceiver
import com.gmediasolutions.demorestaurant.alert.ProgressDialog
import com.gmediasolutions.demorestaurant.fragment.ImageListFragment.Companion.STRING_IMAGE_POSITION
import com.gmediasolutions.demorestaurant.fragment.ImageListFragment.Companion.STRING_IMAGE_URI
import com.gmediasolutions.demorestaurant.pref.UserSession
import kotlinx.android.synthetic.main.activity_cart_list.*

import java.util.ArrayList
import java.util.HashMap

class MyOrderActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener  {

    private var session: UserSession? = null
    var user_token: String? = null
    var user_id: String? = null

    private var networkStateReceiver: NetworkStateReceiver? = null
    private var pDialog: ProgressDialog? = null
    private var mContext: Context? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)
        mContext = this@MyOrderActivity

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.my_orders)
        checkout_bottom.visibility=View.GONE
        price_bottom.visibility=View.GONE
        //check Internet Connection
        networkStateReceiver = NetworkStateReceiver()
        networkStateReceiver!!.addListener(this)
        this.registerReceiver(networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

        //shared prefenced
        session = UserSession(applicationContext)
        val loginuser: HashMap<String, String> = session!!.userDetails
        user_id = loginuser.get(UserSession.USER_ID)
        user_token = loginuser.get(UserSession.USER_TOKEN)

        pDialog = ProgressDialog(this)

        val orderlistImageUri = ImageUrlUtils.orderListImageUrijvm

        //Show cart layout based on items
        setOrderLayout(orderlistImageUri)

        val recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        val recylerViewLayoutManager = LinearLayoutManager(mContext)

        recyclerView.layoutManager = recylerViewLayoutManager
        recyclerView.adapter = MyOrderActivity.SimpleStringRecyclerViewAdapter(recyclerView, orderlistImageUri,
            mContext as MyOrderActivity
        )
    }

    class SimpleStringRecyclerViewAdapter(
        private val mRecyclerView: RecyclerView,
        private val mOrderlistImageUri: ArrayList<String>,
        val mContext: MyOrderActivity
    ) : RecyclerView.Adapter<MyOrderActivity.SimpleStringRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            val mImageView: SimpleDraweeView
            val mLayoutItem: LinearLayout
            val mLayoutIDetail: LinearLayout
            val mLayoutITrack: LinearLayout

            init {
                mImageView = mView.findViewById(R.id.image_orderlist) as SimpleDraweeView
                mLayoutItem = mView.findViewById(R.id.layout_item_desc) as LinearLayout
                mLayoutIDetail= mView.findViewById(R.id.layout_action2) as LinearLayout
                mLayoutITrack= mView.findViewById(R.id.layout_action1) as LinearLayout
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderActivity.SimpleStringRecyclerViewAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_orderlist_item, parent, false)
            return MyOrderActivity.SimpleStringRecyclerViewAdapter.ViewHolder(view)
        }

        override fun onViewRecycled(holder: MyOrderActivity.SimpleStringRecyclerViewAdapter.ViewHolder) {
            if (holder.mImageView.controller != null) {
                holder.mImageView.controller!!.onDetach()
            }
            if (holder.mImageView.topLevelDrawable != null) {
                holder.mImageView.topLevelDrawable!!.callback = null
                //                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
            }
        }

        override fun onBindViewHolder(holder: MyOrderActivity.SimpleStringRecyclerViewAdapter.ViewHolder, position: Int) {
            val uri = Uri.parse(mOrderlistImageUri[position])
            holder.mImageView.setImageURI(uri)
            holder.mLayoutIDetail.setOnClickListener {
                val intent = Intent(mContext, OrderDetailsActivity::class.java)
                intent.putExtra(STRING_IMAGE_URI, mOrderlistImageUri[position])
                intent.putExtra(STRING_IMAGE_POSITION, position)
                mContext!!.startActivity(intent)
            }

        }

        override fun getItemCount(): Int {
            return mOrderlistImageUri.size
        }
    }

     fun setOrderLayout(orderlistImageUri: ArrayList<String>) {
        val layoutCartItems = findViewById(R.id.layout_items) as LinearLayout
        val layoutCartPayments = findViewById(R.id.layout_payment) as LinearLayout
        val layoutCartNoItems = findViewById(R.id.layout_cart_empty) as LinearLayout
        Log.i("addToCartList",MainActivity.countAddToCart.toString())

        if (orderlistImageUri.size > 0) {
            layoutCartNoItems.visibility = View.GONE
            layoutCartItems.visibility = View.VISIBLE
            layoutCartPayments.visibility = View.VISIBLE
        } else {
            layoutCartNoItems.visibility = View.VISIBLE
            layoutCartItems.visibility = View.GONE
            layoutCartPayments.visibility = View.GONE

            Log.i("addToCartList",MainActivity.countAddToCart.toString())
            val bStartShopping = findViewById(R.id.bAddNew) as Button
            bStartShopping.setOnClickListener {
                startActivity(Intent(this,MainActivity::class.java))
                finish() }
        }
    }

    /*Checking Internet Connection and Showing Message*/
    private fun showSnack(isConnected: String) {
        val message: String
        val color: Int
        if (isConnected.equals("true")) {

        } else {
            message = getString(R.string.sorry_nointernet)
            color = Color.RED
            val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            textView.setTextColor(color)
            snackbar.show()
        }
    }

    override fun networkAvailable() {
        showSnack("true")
    }

    override fun networkUnavailable() {
        showSnack("false")
    }

    override fun onDestroy() {
        super.onDestroy()
        networkStateReceiver!!.removeListener(this)
        this.unregisterReceiver(networkStateReceiver)
    }
}
