package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.RetrofitClient
import kotlinx.coroutines.launch

class ThirdActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        recyclerView = findViewById(R.id.recyclerview_comment)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        lifecycleScope.launch {
            val api = RetrofitClient.apiService
            if (api.getPosts().isSuccessful) {
                val posts = api.getPosts().body() ?: emptyList()
                val adapter = PostsAdapter(this@MainActivity,posts)
                recyclerView.adapter = adapter

            } else {
                throw Throwable("no data found")
            }
        }
    }
}