package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        val fragmentsCount = 3
        return fragmentsCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0-> Restoraunt()
            1-> Fitness()
            else -> Cinema()

        }
    }

}