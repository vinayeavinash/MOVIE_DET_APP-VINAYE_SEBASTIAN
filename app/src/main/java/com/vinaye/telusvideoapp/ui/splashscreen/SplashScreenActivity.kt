package com.vinaye.telusvideoapp.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vinaye.telusvideoapp.ui.activities.MainActivity
import com.vinaye.telusvideoapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //action bar hide
        hideActionBar()
        // setup splash screen
        setUpSplashScreen()

    }
    private fun hideActionBar() {
        window.statusBarColor =
            ContextCompat.getColor(applicationContext, R.color.blue_light)
        supportActionBar?.hide()
    }

    private fun setUpSplashScreen() {

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )

    }
}