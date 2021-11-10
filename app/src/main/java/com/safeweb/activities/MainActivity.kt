package com.safeweb.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.safeweb.Utils
import com.safeweb.databinding.MainActivityBinding


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
            val bundle = Bundle()
            bundle.putSerializable("mode", EducationActivity.Mode.CHILD)
            Utils.goToEducationActivity(this, bundle)
        }

        binding.educationParentButtonId.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("mode", EducationActivity.Mode.PARENT)
            Utils.goToEducationActivity(this, bundle)
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
