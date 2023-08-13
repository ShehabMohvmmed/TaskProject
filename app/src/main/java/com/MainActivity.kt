package com

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cheesecake.taskproject.R
import com.remote.AuthRetrofitClient
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUsername: EditText = findViewById(R.id.et_username)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val apiService = AuthRetrofitClient.apiService

        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                val requestBody = mapOf(
                    "username" to username,
                    "password" to password
                )
                val request = apiService.login(requestBody)
                if (request.isSuccessful) {
                    moveToSecondScreen()
                } else {
                    val errorResponse = request.errorBody()?.string()
                    val errorMessage = JSONObject(errorResponse ?: "").getString("message")
                    showToast(errorMessage)
                }
            }
        }
    }

    private fun moveToSecondScreen() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}