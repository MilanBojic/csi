package com.safeweb.components

import android.content.Context
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.safeweb.R
import com.safeweb.Utils
import com.safeweb.items.EducationItem

class EducationAdapter(private val mContext: Context, private val mListDataProvider: List<EducationItem>) : PagerAdapter() {
    private lateinit var mTitle: TextView
    private lateinit var mDesc: TextView
    private lateinit var mLogo: ImageView
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.education_content, collection, false) as ViewGroup
        mTitle = layout.findViewById(R.id.education_title)
        mDesc = layout.findViewById(R.id.education_info)
        mLogo = layout.findViewById(R.id.education_logo)
        mTitle.setText(mListDataProvider[position].title)
        mDesc.setText(mListDataProvider[position].info)
        mLogo.setImageDrawable(Utils.getDrawable(mContext, mListDataProvider[position].logo))
        mLogo.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
        collection.addView(layout)

        return layout
    }

    override fun getCount(): Int {
        return mListDataProvider.size
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


}
