package com.gmediasolutions.demorestaurant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.support.v4.content.res.ResourcesCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.gmediasolutions.demorestaurant.pref.UserSession
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000
    private var session: UserSession? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        session = UserSession(this@SplashScreen)

        val typeface = ResourcesCompat.getFont(this, R.font.pacifico)

        appname_tv.setTypeface(typeface)

        YoYo.with(Techniques.Tada)
                .duration(7000)
                .playOn(findViewById(R.id.logo))

        YoYo.with(Techniques.FadeIn)
                .duration(5000)
                .playOn(findViewById(R.id.appname_tv))

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
    }

