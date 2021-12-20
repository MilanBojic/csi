package com.csi.activities

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.csi.R
import com.csi.databinding.ContactLayoutBinding

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ContactLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.contactExplanationId.contactTitle.setText(R.string.tKontakt)

        binding.contactExplanationId.contactInfo.setText(R.string.tContactDesc)
        binding.contactExplanationId.contactInfo.movementMethod = LinkMovementMethod.getInstance()
    }
}
