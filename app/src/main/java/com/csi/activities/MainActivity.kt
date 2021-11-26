package com.csi.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.csi.Utils
import com.csi.databinding.MainActivityBinding


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
            bundle.putInt("mode", 1)
            Utils.goToWebActivity(this, bundle)
        }
        binding.reportButtonId.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Utils.URL, Utils.reportUrl)
            bundle.putInt("mode", 0)
            Utils.goToWebActivity(this, bundle)
        }


    }


}
