package com.kotlin.submission1.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kotlin.submission1.databinding.ActivityHomeBinding
import com.synnapps.carouselview.ImageListener

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

//    val imageBackground = intArrayOf(
//        R.drawable.bg_joker,
//        R.drawable.bg_6_underground,
//        R.drawable.bg_avenger_end_game,
//        R.drawable.bg_godzilla,
//        R.drawable.bg_hobbs_shaw,
//        R.drawable.bg_jumanji
//    )

    private val imageBackground = arrayOf(
        "https://image.tmdb.org/t/p/original/2Fk3AB8E9dYIBc2ywJkxk8BTyhc.jpg",
        "https://image.tmdb.org/t/p/original/9xeEGUZjgiKlI69jwIOi0hjKUIk.jpg",
        "https://image.tmdb.org/t/p/original/mGJuQwMq1bEboaVTqQAK4p4zQvC.jpg",
        "https://image.tmdb.org/t/p/original/1R6cvRtZgsYCkh8UFuWFN33xBP4.jpg",
        "https://image.tmdb.org/t/p/original/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBanner.pageCount = imageBackground.size
        binding.ivBanner.setImageListener(imageListener)

        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    private val imageListener = ImageListener { position, imageView ->
//        imageView.setImageResource(imageBackground[position])
        Glide.with(applicationContext)
            .load(imageBackground[position])
            .into(imageView)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}