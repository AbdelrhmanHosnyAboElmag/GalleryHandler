package com.example.galleryhandler.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.galleryhandler.ui.fragment.PictureFragment
import com.example.galleryhandler.ui.fragment.VideoFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2  // Number of fragments in the ViewPager
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PictureFragment()  // First fragment
            1 -> VideoFragment()  // Second fragment
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}