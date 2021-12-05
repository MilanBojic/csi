package com.csi.activities

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.csi.Utils
import com.csi.databinding.WebViewLayoutBinding


class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: WebViewLayoutBinding
    private var urlToLoad: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = WebViewLayoutBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        urlToLoad = intent.getStringExtra(Utils.URL) as String
        val mode = intent.getIntExtra("mode", 0) as Int
        if(mode ==0){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        binding.webView.loadUrl(urlToLoad)
        binding.webView.setWebViewClient(WebViewClient())


    }


}
