package com

import UserAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.RetrofitClient
import com.remote.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val apiService = RetrofitClient.instance
        val response = apiService.getUsers()
        val users = if (response.isSuccessful){
            response.body()?.data!!
        } else {
            throw Throwable("data not found")
        }
        val adapter = UserAdapter(users)
        recyclerView.adapter = adapter
    }
}