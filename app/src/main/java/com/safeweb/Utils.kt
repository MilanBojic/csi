package com.safeweb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.activities.MainActivity
import com.safeweb.activities.WebViewActivity

object Utils {

    val reportUrl
        get() = "https://netpatrola.rs/prijavite-sadrzaj/"

    val playGameUrl
        get() = "https://tijana.rs/bezbednost-na-internetu/index.html"

    val URL
        get() = "URL"


    fun goToMainActivity(from: AppCompatActivity, data: Bundle? = null) {
        val goToMainActivityIntent = Intent(from, MainActivity::class.java)
        if (data != null) goToMainActivityIntent.putExtras(data)
        from.startActivity(goToMainActivityIntent)
    }

    fun goToWebActivity(from: AppCompatActivity, data: Bundle? = null) {
        val goToMainActivityIntent = Intent(from, WebViewActivity::class.java)
        if (data != null) goToMainActivityIntent.putExtras(data)
        from.startActivity(goToMainActivityIntent)
    }

    fun toastShort(context: Context, value: String) {
        Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(context: Context, value: String) {
        Toast.makeText(context, value, Toast.LENGTH_LONG).show()

    }
}
