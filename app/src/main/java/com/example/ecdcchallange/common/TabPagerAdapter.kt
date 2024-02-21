package com.example.ecdcchallange.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecdcchallange.orders.AllOrderFragment
import com.example.ecdcchallange.orders.AssignedOrderFragment

class TabPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllOrderFragment()
            1 -> AssignedOrderFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}