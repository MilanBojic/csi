package com.csi

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.csi.activities.*


object Utils {

    val reportUrl
        get() = "https://netpatrola.rs/prijavite-sadrzaj/"

    val playGameUrl
        get() = "https://tijana.rs/bezbednost-na-internetu/index.html"

    val newsUrl
        get() = "https://cnzd.rs/kategorije/vesti/"

    val URL
        get() = "URL"


    fun goToMainActivity(from: AppCompatActivity, data: Bundle? = null) {
        val goToMainActivityIntent = Intent(from, MainActivity::class.java)
        if (data != null) goToMainActivityIntent.putExtras(data)
        from.startActivity(goToMainActivityIntent)
    }

    fun goToWebActivity(from: FragmentActivity, data: Bundle? = null) {
        val goToMainActivityIntent = Intent(from, WebViewActivity::class.java)
        if (data != null) goToMainActivityIntent.putExtras(data)
        from.startActivity(goToMainActivityIntent)
    }

    fun goToEducationActivity(from: FragmentActivity, data: Bundle? = null) {
        val goToEducationActivity = Intent(from, EducationActivity::class.java)
        if (data != null) goToEducationActivity.putExtras(data)
        from.startActivity(goToEducationActivity)
    }

    fun goToAboutActivity(from: FragmentActivity, data: Bundle? = null) {
        val goToAboutActivity = Intent(from, AboutActivity::class.java)
        if (data != null) goToAboutActivity.putExtras(data)
        from.startActivity(goToAboutActivity)
    }

    fun goToContactActivity(from: FragmentActivity, data: Bundle? = null) {
        val goToContactActivity = Intent(from, ContactActivity::class.java)
        if (data != null) goToContactActivity.putExtras(data)
        from.startActivity(goToContactActivity)
    }

    fun toastShort(context: Context, value: String) {
        Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(context: Context, value: String) {
        Toast.makeText(context, value, Toast.LENGTH_LONG).show()

    }

    fun getDrawable(context: Context, @DrawableRes drawable: Int): Drawable? {
        return context.resources.getDrawable(drawable, context.theme)
    }

}
