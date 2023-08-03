package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.cheesecake.taskproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val cbFootball: CheckBox = findViewById(R.id.cbFootball)
        val cbBasketball: CheckBox = findViewById(R.id.cbBasketball)
        val cbVolleyball: CheckBox = findViewById(R.id.cbVolleyball)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val btnRegister: Button = findViewById(R.id.btn_register)

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

            val toastMessage = "Username: $username\nPassword: $password\nSelected Sports: ${selectedSports.dropLast(2)}\nSelected Gender: $selectedGender"
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }
    }
}