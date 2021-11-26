package com.csi.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import io.reactivex.subjects.PublishSubject

@SuppressLint("SetJavaScriptEnabled")
class SafeWebView(context: Context, attributeSet: AttributeSet?) : WebView(context, attributeSet) {
    val overrideUrlObservable = PublishSubject.create<String>().toSerialized()
    val loadPageFinishedObservable = PublishSubject.create<String>().toSerialized()
    val loadPageStartedObservable = PublishSubject.create<String>().toSerialized()

    private val TAG = "SafeWebView"

    init {
        setBackgroundColor(Color.TRANSPARENT)
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        settings.setUseWideViewPort(true)
        settings.setLoadWithOverviewMode(true)

        //enable/disable zoom in Webview
        settings.builtInZoomControls = true

        clearCache(true)
        this.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, urlNewString: String): Boolean {
                if (urlNewString.isEmpty()) return false
                Log.i(TAG, "shouldOverrideUrlLoading= " + urlNewString)
                overrideUrlObservable.onNext(urlNewString)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, facIcon: Bitmap?) {
                if (TextUtils.isEmpty(url)) return
                loadPageStartedObservable.onNext(url!!)
                super.onPageStarted(view, url, favicon)

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if (TextUtils.isEmpty(url)) return
                loadPageFinishedObservable.onNext(url!!)
                super.onPageFinished(view, url)

            }
        })

    }

}
