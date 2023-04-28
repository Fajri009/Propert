package com.propert.OnBoardPage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.propert.R

class ViewPagerAdapter(val context : Context) : PagerAdapter() {
    var layoutInflater : LayoutInflater? = null

    val gambarArray = arrayOf(
        R.drawable.onboard1,
        R.drawable.onboard2,
        R.drawable.onboard3
    )

    val judulArray = arrayOf(
        "Pelatihan disesuaikan dengan Kebutuhan Kerja",
        "Pelatihan Interaktif",
        "Belajar di mana saja dan kapan saja"
    )

    val deskripsiArray = arrayOf(
        "Kurikulum Propert menyesuaikan dengan posisi pekerjaan dan level keahlian, kamu dapat memperoleh keterampilan yang sesuai dengan tujuan karir kamu.",
        "Kamu dapat belajar dengan interaktif dengan video yang menarik, tutor yang asik dan tutor yang memberikan penjelasan yang sangat lengkap!",
        "Kamu dapat mengakses course di mana saja dan kapan saja secara flexible!"
    )

    override fun getCount(): Int {
        return judulArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.onboard_layout, container, false)

        val gambar = view.findViewById<ImageView>(R.id.gambarOnboard)
        val judul = view.findViewById<TextView>(R.id.judulOnboard)
        val deskripsi = view.findViewById<TextView>(R.id.deskripsiOnboard)

        gambar.setImageResource(gambarArray[position])
        judul.text = judulArray[position]
        deskripsi.text = deskripsiArray[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}