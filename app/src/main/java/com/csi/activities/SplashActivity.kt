package com.csi.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.csi.R
import com.csi.Utils
import kotlinx.coroutines.*
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        GlobalScope.launch {
            delay(2500)
            Utils.goToMainActivity(this@SplashActivity)
            this@SplashActivity.finish()
        }

    }


}
