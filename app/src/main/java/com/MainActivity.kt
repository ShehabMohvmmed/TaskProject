package com

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.cheesecake.taskproject.R
import com.remoteDataSource.model.LoginRequestBody
import com.viewModel.MainViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val etUsername: EditText = findViewById(R.id.et_username)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                val requestBody = LoginRequestBody(username,password)
                val request = viewModel.login(requestBody)
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