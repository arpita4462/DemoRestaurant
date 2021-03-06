package com.gmediasolutions.demorestaurant

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.facebook.drawee.view.SimpleDraweeView
import com.gmediasolutions.demorestaurant.alert.NetworkStateReceiver
import com.gmediasolutions.demorestaurant.alert.ProgressDialog
import com.gmediasolutions.demorestaurant.fragment.ImageListFragment
import com.gmediasolutions.demorestaurant.navdrawerOptions.CartListActivity
import com.gmediasolutions.demorestaurant.pref.UserSession

class ItemDetailsActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {
    private var session: UserSession? = null
    var user_token: String? = null
    var user_id: String? = null

    private var networkStateReceiver: NetworkStateReceiver? = null

    private var pDialog: ProgressDialog? = null

    internal var imagePosition: Int = 0
    internal var stringImageUri: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        val mImageView = findViewById(R.id.image1) as SimpleDraweeView
        val textViewAddToCart = findViewById(R.id.text_action_bottom2) as TextView
        val textViewBacktoMenu = findViewById(R.id.text_action_bottom1) as TextView

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

        //Getting image uri from previous screen
        if (intent != null) {
            stringImageUri = intent.getStringExtra(ImageListFragment.STRING_IMAGE_URI)
            imagePosition = intent.getIntExtra(ImageListFragment.STRING_IMAGE_URI, 0)
        }


        val uri = Uri.parse(stringImageUri)
        mImageView.setImageURI(uri)

        textViewAddToCart.setOnClickListener {
//            val imageUrlUtils = ImageUrlUtils()
            ImageUrlUtils.addCartListImageUri(stringImageUri!!)
            Log.i("addToCartList09",stringImageUri.toString())
            Toast.makeText(this@ItemDetailsActivity, "Item added to cart.", Toast.LENGTH_SHORT).show()
//            session!!.increaseCartValue()
            MainActivity.countAddToCart++
            Log.i("addToCart",MainActivity.countAddToCart.toString())
//            startActivity(Intent(this@ItemDetailsActivity, CartListActivity::class.java))
            val intent = Intent(this@ItemDetailsActivity, CartListActivity::class.java)
            intent.putExtra(ImageListFragment.STRING_IMAGE_URI, stringImageUri)
            startActivity(intent)
        }

        textViewBacktoMenu.setOnClickListener {
            startActivity(Intent(this@ItemDetailsActivity, MainActivity::class.java))
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
