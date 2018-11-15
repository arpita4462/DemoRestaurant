package com.gmediasolutions.demorestaurant

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_deliver.*
import java.text.DecimalFormat
import java.util.*
import android.widget.DatePicker
import android.widget.TimePicker
import com.gmediasolutions.demorestaurant.alert.NetworkStateReceiver
import com.gmediasolutions.demorestaurant.fragment.ImageListFragment
import com.gmediasolutions.demorestaurant.navdrawerOptions.CartListActivity
import com.gmediasolutions.demorestaurant.pref.UserSession


class CheckoutActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {

    private var session: UserSession? = null
    var user_token: String? = null
    var user_id: String? = null

    private var networkStateReceiver: NetworkStateReceiver? = null
    private var pDialog: ProgressDialog? = null
    private var mContext: Context? = null

     var btnSend: Button? = null
//     var edtName: EditText? = null
//     var edtName2:EditText? = null
//     var edtPhone:EditText? = null
//     var edtOrderList:EditText? = null
//     var edtComment:EditText? = null
//     var edtAlamat:EditText? = null
//     var edtEmail:EditText? = null
//     var edtKota:EditText? = null
//     var edtProvinsi:EditText? = null
//     var sclDetail: ScrollView? = null
//     var prgLoading: ProgressBar? = null
//     var txtAlert: TextView? = null
//     var spinner: Spinner? = null

    // declare dbhelper object
//    var dbhelper: DBHelper
     var data: ArrayList<ArrayList<Any>>? = null

    // declare string variables to store data
     var Name: String? = null
     var Name2:String? = null
     var Date:String? = null
     var Time:String? = null
     var Phone:String? = null
     var Date_n_Time:String? = null
     var Alamat:String? = null
     var Email:String? = null
     var Kota:String? = null
     var Provinsi:String? = null
     var OrderList = ""
     var Comment = ""

    // create price format
    internal var formatData = DecimalFormat("#.##")

     var Result: String? = null
     var TaxCurrencyAPI: String? = null
     var IOConnect = 0

    internal var stringImageUri: String?=null

    companion object {
        private var mYear: Int = 0
        private var mMonth: Int = 0
        private var mDay: Int = 0
        private var mHour: Int = 0
        private var mMinute: Int = 0

        // declare static variables to store tax and currency data
        var Tax: Double = 0.toDouble()
        var Currency: String?=null


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliver)
        mContext = this@CheckoutActivity

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


//        edtName = findViewById<View>(R.id.edtName) as EditText
//        edtEmail = findViewById<View>(R.id.edtEmail) as EditText
//        edtPhone = findViewById<View>(R.id.edtPhone) as EditText
//        edtOrderList = findViewById<View>(R.id.edtOrderList) as EditText
//        edtComment = findViewById<View>(R.id.edtComment) as EditText
        btnSend = findViewById(R.id.btn_Send) as Button
//        sclDetail = findViewById<View>(R.id.sclDetail) as ScrollView
//        edtAlamat = findViewById<View>(R.id.edtAlamat) as EditText
//        edtKota = findViewById<View>(R.id.edtKota) as EditText
//        edtProvinsi = findViewById<View>(R.id.edtProvinsi) as EditText

        if (intent != null) {
            stringImageUri = intent.getStringExtra(ImageListFragment.STRING_IMAGE_URI)
        }

        // event listener to handle send button when pressed
        btnSend!!.setOnClickListener {

            ImageUrlUtils.addOrderListImageUri(stringImageUri!!)
            ImageUrlUtils.clearCartListImageUri()
            MainActivity.countAddToCart=0
            Toast.makeText(this, "Make payment of your order", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,OrderConfirmActivity::class.java))

            // get data from all forms and send to server
            /* Name = edtName!!.getText().toString()
                Alamat = edtAlamat!!.getText().toString()
                Kota = edtKota!!.getText().toString()
                Provinsi = edtProvinsi!!.getText().toString()
                Email = edtEmail!!.getText().toString()
                Date = btnDate!!.getText().toString()
                Time = btnTime!!.getText().toString()
                Phone = edtPhone!!.getText().toString()
                Comment = edtComment!!.getText().toString()
                Date_n_Time = "$Date $Time"
                if (Name.equals("", ignoreCase = true) || Name2.equals("", ignoreCase = true) || Email.equals("", ignoreCase = true) || Alamat.equals("", ignoreCase = true) || Kota.equals("", ignoreCase = true) || Provinsi.equals("", ignoreCase = true) ||
                        Date.equals(getString(R.string.checkout_set_date), ignoreCase = true) ||
                        Time.equals(getString(R.string.checkout_set_time), ignoreCase = true) ||
                        Phone.equals("", ignoreCase = true)) {
                    Toast.makeText(this, R.string.form_alert, Toast.LENGTH_SHORT).show()
                } else if (data!!.size == 0) {
                    Toast.makeText(this, R.string.order_alert, Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this,PaymentActivity::class.java))

                }*/
        }
    }




    override fun onResume() {
        super.onResume()
        networkStateReceiver!!.addListener(this)
        this.registerReceiver(networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onStop() {
        super.onStop()

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
