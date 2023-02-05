package com.example.practice_01.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.practice_01.fragment.InfoFragment
import com.example.practice_01.fragment.MenuFragment
import com.example.practice_01.fragment.ReviewFragment

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        val fragment = when(position) {
            0 -> MenuFragment().newInstance()
            1 -> InfoFragment().newInstance()
            2 -> ReviewFragment().newInstance()
            else -> MenuFragment().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position) {
            0 -> "메뉴"
            1 -> "정보"
            2 -> "리뷰"
            else -> "메뉴"
        }
        return title
    }


}