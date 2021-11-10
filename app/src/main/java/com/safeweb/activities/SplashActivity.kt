package com.safeweb.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.R
import com.safeweb.Utils
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        GlobalScope.launch {
            delay(1000)
            Utils.goToMainActivity(this@SplashActivity)
            this@SplashActivity.finish()
        }

    }


}
