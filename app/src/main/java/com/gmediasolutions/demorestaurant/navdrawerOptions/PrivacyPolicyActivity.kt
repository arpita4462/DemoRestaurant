package com.gmediasolutions.demorestaurant.navdrawerOptions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.webkit.WebView
import com.gmediasolutions.demorestaurant.R
import com.gmediasolutions.demorestaurant.alert.ProgressDialog

class PrivacyPolicyActivity : AppCompatActivity() {

    private var pDialog: ProgressDialog? = null

    var info: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termscond)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.privacy_policy)

        info = findViewById(R.id.about_us_web)
        pDialog = ProgressDialog(this)
        pDialog!!.show()
        try {
            pDialog!!.dismiss()
            info!!.loadUrl("file:///android_asset/privacypolicy.html")
        } catch (e: Exception) {
            e.printStackTrace()

        }

    }
    override fun onStart() {
        super.onStart()
        try {
            pDialog!!.dismiss()
            info!!.loadUrl("file:///android_asset/privacypolicy.html")
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

}
