package com.csi.activities

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.csi.R
import com.csi.components.EducationAdapter
import com.csi.databinding.EducationRootLayoutBinding
import com.csi.items.EducationItem
import java.util.ArrayList


class EducationActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private lateinit var binding: EducationRootLayoutBinding

    private var index = 0
    private var adapter: EducationAdapter? = null

    private var mode: Mode = Mode.CHILD

    enum class Mode {
        PARENT, CHILD
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EducationRootLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mode = intent.getSerializableExtra("mode") as Mode

        adapter = EducationAdapter(this, data)
        binding.educationPager.adapter = adapter
        binding.educationPager.overScrollMode = View.OVER_SCROLL_NEVER
        binding.educationPager.offscreenPageLimit = adapter!!.count - 1
        binding.educationPager.addOnPageChangeListener(this)
        binding.educationPager.currentItem = index
    }

    override fun onStart() {
        super.onStart()
        binding.educationNext.setOnClickListener {
            if (binding.educationPager.currentItem + 1 >= adapter!!.count) {
            } else {
                binding.educationPager.currentItem = binding.educationPager.currentItem + 1
            }
        }

        binding.educationBack.setOnClickListener {
            binding.educationPager.currentItem = 0
        }

    }

    val data: List<EducationItem>
        get() {
            when (mode) {
                Mode.CHILD -> return childData
                Mode.PARENT -> return parentData
            }
        }


    val childData: List<EducationItem>
        get() {
            val result = ArrayList<EducationItem>()
            val logoArray = resources.obtainTypedArray(R.array.education_child_drawables)
            val titleArray = applicationContext.resources.getStringArray(R.array.education_child_title_array)
            val infoArray = applicationContext.resources.getStringArray(R.array.education_child_info_array)

            for (i in infoArray.indices) {
                val info = infoArray[i]
                if (!TextUtils.isEmpty(info)) {
                    result.add(EducationItem(logoArray.getResourceId(i, 0), titleArray[i], info))
                }
            }

            logoArray.recycle()

            return result

        }

    val parentData: List<EducationItem>
        get() {
            val result = ArrayList<EducationItem>()
            val logoArray = resources.obtainTypedArray(R.array.education_parent_drawables)
            val titleArray = applicationContext.resources.getStringArray(R.array.education_parent_title_array)
            val infoArray = applicationContext.resources.getStringArray(R.array.education_parent_info_array)

            for (i in infoArray.indices) {
                val info = infoArray[i]
                if (!TextUtils.isEmpty(info)) {
                    result.add(EducationItem(logoArray.getResourceId(i, 0), titleArray[i], info))
                }
            }

            logoArray.recycle()

            return result

        }


    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

        updateUI()

    }

    private fun updateUI() {
        if (binding.educationPager.currentItem + 1 == adapter!!.count) {
            binding.educationNext.visibility = View.INVISIBLE
        } else {
            binding.educationNext.visibility = View.VISIBLE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }


}
