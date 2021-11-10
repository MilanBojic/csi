package com.safeweb.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.R
import com.safeweb.Utils
import com.safeweb.databinding.MainActivityBinding
import com.safeweb.screens.WebViewFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.educationChildButtonId.setOnClickListener {
            Utils.toastShort(this, "edukacija - dete")
        }

        binding.educationParentButtonId.setOnClickListener {
            Utils.toastShort(this, "edukacija - roditelj")
        }


        binding.playGameButtonId.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(Utils.URL, Utils.playGameUrl)
            Utils.goToWebActivity(this, bundle)
        }
        binding.reportButtonId.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Utils.URL, Utils.reportUrl)
            Utils.goToWebActivity(this, bundle)

        }


    }



}
