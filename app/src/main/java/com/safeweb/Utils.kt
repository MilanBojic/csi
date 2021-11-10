package com.safeweb

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.activities.MainActivity
import com.safeweb.activities.WebViewActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.safeweb.activities.EducationActivity


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

    fun goToEducationActivity(from: AppCompatActivity, data: Bundle? = null) {
        val goToEducationActivity = Intent(from, EducationActivity::class.java)
        if (data != null) goToEducationActivity.putExtras(data)
        from.startActivity(goToEducationActivity)
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

    fun loadFragment(activity: AppCompatActivity, replaceLayoutID: Int, fragment: Fragment, tag: String) {
        val manager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(replaceLayoutID, fragment, tag)
        transaction.addToBackStack(tag)
        transaction.commit()
    }
}
