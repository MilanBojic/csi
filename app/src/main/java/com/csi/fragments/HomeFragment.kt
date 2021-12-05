package com.csi.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.csi.databinding.FragmentHomeBinding

import com.csi.R
import com.csi.Utils

class HomeFragment : androidx.fragment.app.Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.educationButtonId.setOnClickListener(this)
        binding.reportButtonId.setOnClickListener(this)
        binding.playGameButtonId.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.education_button_id -> {
                Utils.goToEducationActivity(requireActivity())
            }
            R.id.play_game_button_id -> {
                val bundle = Bundle()
                bundle.putString(Utils.URL, Utils.playGameUrl)
                bundle.putInt("mode", 1)
                Utils.goToWebActivity(requireActivity(), bundle)
            }
            R.id.report_button_id -> {
                val bundle = Bundle()
                bundle.putString(Utils.URL, Utils.reportUrl)
                bundle.putInt("mode", 0)
                Utils.goToWebActivity(requireActivity(), bundle)
            }

        }
    }


}

