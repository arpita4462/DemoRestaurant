package com.gmediasolutions.demorestaurant

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.gmediasolutions.demorestaurant.alert.NetworkStateReceiver
import com.gmediasolutions.demorestaurant.alert.ProgressDialog
import com.gmediasolutions.demorestaurant.pref.UserSession
import java.util.HashMap
import com.gmediasolutions.demorestaurant.custom.CheckView
import kotlinx.android.synthetic.main.activity_orderconfirm.*


class OrderConfirmActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {
    private var session: UserSession? = null
    var user_token: String? = null
    var user_id: String? = null

    private var networkStateReceiver: NetworkStateReceiver? = null
    private var pDialog: ProgressDialog? = null
    private var mContext: Context? = null
    private var mViews: Views? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderconfirm)

        mContext = this@OrderConfirmActivity

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

//        checkview
        mViews = Views(this)
        mViews!!.check.check()

        btn_conti.setOnClickListener {
            startActivity(Intent(this@OrderConfirmActivity, MainActivity::class.java))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@OrderConfirmActivity, MainActivity::class.java))
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



    internal class Views(activity: OrderConfirmActivity) {
        var check: CheckView
        init {
            check = activity.findViewById(R.id.check) as CheckView
        }
    }
}
