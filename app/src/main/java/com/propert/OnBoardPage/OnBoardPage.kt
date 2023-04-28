package com.propert.OnBoardPage

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.propert.R
import com.propert.SigninAndLogin.LoginPage
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardPage : AppCompatActivity() {
    private lateinit var viewPager : ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var lewati : TextView
    private lateinit var selanjutnya : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboard_page)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val intent = Intent(this, LoginPage::class.java)

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }

        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter =  ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        lewati = findViewById(R.id.lewati)
        selanjutnya = findViewById(R.id.selanjutnya)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == viewPagerAdapter.count - 1) {
                    lewati.visibility = View.GONE
                } else {
                    lewati.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        dotsIndicator.attachTo(viewPager)
        skip(intent)
        next(intent)
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    private fun skip(intent: Intent) {
        lewati.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun next(intent: Intent) {
        selanjutnya.setOnClickListener {
            if (viewPager.currentItem == viewPagerAdapter.count - 1) {
                startActivity(intent)
            } else {
                viewPager.currentItem += 1
            }
        }
    }
}