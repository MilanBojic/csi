package com.safeweb.activities

import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.Utils
import com.safeweb.databinding.WebViewLayoutBinding


class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: WebViewLayoutBinding
    private var urlToLoad: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = WebViewLayoutBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        urlToLoad = intent.getStringExtra(Utils.URL) as String

        binding.webView.loadUrl(urlToLoad)
        binding.webView.setWebViewClient(WebViewClient())


    }


}
