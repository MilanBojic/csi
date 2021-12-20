package com.csi.activities

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.csi.R
import com.csi.Utils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    private var disposableTimer: Disposable? = null

    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
        val splashLogo = findViewById<ImageView>(R.id.splash_logo)
        val logoArray = resources.obtainTypedArray(R.array.splash_drawables)

        disposableTimer = Observable.interval(50, TimeUnit.MILLISECONDS)
            .timeInterval()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

                if (count == logoArray.length()) {
                    Utils.goToMainActivity(this@SplashActivity)

                    this@SplashActivity.finish()
                    disposableTimer?.dispose()
                    return@subscribe

                }
                val drawable = logoArray.getDrawable(count)
                splashLogo.setImageDrawable(drawable)
                count += 1

            }


    }


}
