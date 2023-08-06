package com

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.MainActivity.Companion.EXTRA_PASSWORD
import com.MainActivity.Companion.EXTRA_SELECTED_GENDER
import com.MainActivity.Companion.EXTRA_SELECTED_LOGIN_METHOD
import com.MainActivity.Companion.EXTRA_SELECTED_SPORTS
import com.MainActivity.Companion.EXTRA_USERNAME
import com.cheesecake.taskproject.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASSWORD)
        val selectedSports = intent.getStringExtra(EXTRA_SELECTED_SPORTS)
        val selectedGender = intent.getStringExtra(EXTRA_SELECTED_GENDER)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val radioGroupLogin: RadioGroup = findViewById(R.id.rg_login_methods)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        tvUsername.text = username

        val toastMessage =
            "Username: $username Password: $password Selected Sports: $selectedSports Selected Gender: $selectedGender"
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()

        btnLogin.setOnClickListener {
            val selectedLoginMethod = when (radioGroupLogin.checkedRadioButtonId) {
                R.id.rbFacebook -> "facebook"
                R.id.rbGoogle -> "google"
                else -> "unknown"
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EXTRA_SELECTED_LOGIN_METHOD, selectedLoginMethod)
            startActivity(intent)
        }
    }
}