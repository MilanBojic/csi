package com.csi.activities

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.csi.R
import com.csi.databinding.AboutLayoutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: AboutLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.aboutExplanationId.aboutTitle.setText(R.string.tAbout)

        binding.aboutExplanationId.aboutInfo.setText(R.string.tAboutDesc)
        binding.aboutExplanationId.aboutInfo.movementMethod = LinkMovementMethod.getInstance()
    }
}
