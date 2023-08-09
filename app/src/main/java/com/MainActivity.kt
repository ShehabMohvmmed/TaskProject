package com

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.PrefsUtil.Companion.initPrefs
import com.PrefsUtil.Companion.isLoggedIn
import com.PrefsUtil.Companion.setPrefs
import com.cheesecake.taskproject.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPrefs(this)

        if (isLoggedIn!!) {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        Log.i( "onCreate: ", isLoggedIn.toString())

        val etUsername: EditText = findViewById(R.id.et_username)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val cbFootball: CheckBox = findViewById(R.id.cbFootball)
        val cbBasketball: CheckBox = findViewById(R.id.cbBasketball)
        val cbVolleyball: CheckBox = findViewById(R.id.cbVolleyball)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val btnRegister: Button = findViewById(R.id.btn_register)

        val intent = intent
        val loginMethod = intent.getStringExtra(MainActivity.EXTRA_SELECTED_LOGIN_METHOD)
        if (loginMethod != null) {
            val toastMessage = "Logged in by: $loginMethod"
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val selectedSports = StringBuilder()
            if (cbFootball.isChecked) {
                selectedSports.append("Football, ")
            }
            if (cbBasketball.isChecked) {
                selectedSports.append("Basketball, ")
            }
            if (cbVolleyball.isChecked) {
                selectedSports.append("Volleyball, ")
            }

            val selectedGender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "unknown"
            }

            setPrefs(username,password)
            isLoggedIn = true
            Log.i( "onCreate: ", isLoggedIn.toString())

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, username)
            intent.putExtra(EXTRA_PASSWORD, password)
            intent.putExtra(EXTRA_SELECTED_SPORTS, selectedSports.dropLast(2).toString())
            intent.putExtra(EXTRA_SELECTED_GENDER, selectedGender)
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
        const val EXTRA_SELECTED_SPORTS = "extra_selected_sports"
        const val EXTRA_SELECTED_GENDER = "extra_selected_gender"
        const val EXTRA_SELECTED_LOGIN_METHOD = "extra_selected_login_method"
    }
}