package com.vogt.sebastian.becalculator

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // hide the actionbar
        supportActionBar?.hide()



        //window.decorView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))


        android.os.Handler().postDelayed({
            //Log.i("asd", "Huhu nach 5 sek")
            var mainIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)

        }, 3000)
    }
}
