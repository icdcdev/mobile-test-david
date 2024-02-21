package com.example.ecdcchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecdcchallange.common.TabPagerAdapter
import com.example.ecdcchallange.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        val adapter = TabPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) "NO ASIGNADAS" else "ASIGNADAS"
        }.attach()

    }
}