package com.safeweb.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.safeweb.R
import com.safeweb.Utils
import com.safeweb.components.SafeWebView
import android.webkit.WebViewClient


class WebViewFragment : Fragment() {
    private lateinit var webView: SafeWebView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.web_view_layout, container, false)



        webView = view.findViewById(R.id.web_view)
        webView.loadUrl(Utils.playGameUrl)
        webView.setWebViewClient(WebViewClient())

        return view

    }


}
