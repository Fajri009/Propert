package com.propert.SigninAndLogin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.propert.R

class LoginPage : AppCompatActivity() {
    private lateinit var lupaPassword : TextView
    private lateinit var daftar : TextView
    private var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        lupaPassword = findViewById(R.id.lupaPassword)
        daftar = findViewById(R.id.signinButton)

        lupaPassword()
        daftar()
    }

    private fun lupaPassword() {
        lupaPassword.setOnClickListener {
            startActivity(Intent(this, LupaPasswordPage::class.java))
        }
    }

    private fun daftar() {
        daftar.setOnClickListener {
            startActivity(Intent(this, SigninPage::class.java))
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
            backPressedTime = System.currentTimeMillis()
        }
    }
}