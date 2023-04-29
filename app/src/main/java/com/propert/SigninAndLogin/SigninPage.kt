package com.propert.SigninAndLogin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.propert.R

class SigninPage : AppCompatActivity() {
    private lateinit var masuk : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_page)

        masuk = findViewById(R.id.loginButton)

        masuk()
    }

    private fun masuk() {
        masuk.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
        }
    }
}