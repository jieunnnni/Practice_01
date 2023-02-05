package com.example.practice_01.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.practice_01.Items
import com.example.practice_01.adapter.ViewPagerAdapter
import com.example.practice_01.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = intent.getParcelableExtra<Items>("restaurantItem")

        binding.titleTextView.text = items?.PTR_PROM_TITLE.orEmpty()
        binding.foodNameTextView.text = items?.PTR_COM_NM.orEmpty()
        Glide.with(binding.detailImageView.context)
            .load(items?.PTR_PRO_IMG.orEmpty())
            .into(binding.detailImageView)

        viewPager()

    }

    private fun viewPager() = with(binding) {
       val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }



}