package com

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.PostsApiService
import com.remote.RetrofitClient
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGet: Button
    private lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        editText = findViewById(R.id.edtText_Id)
        buttonGet = findViewById(R.id.btn_get)
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val postApiService = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/").create(
            PostsApiService::class.java)

        lifecycleScope.launch {
            if (postApiService.getPosts().isSuccessful) {
                val posts = postApiService.getPosts().body() ?: emptyList()
                val adapter = PostsAdapter(this@SecondActivity,posts)
                recyclerView.adapter = adapter

                buttonGet.setOnClickListener {
                    if (editText.text.isNotEmpty()) {
                        lifecycleScope.launch {
                            val request = postApiService.getPostsByUserId(editText.text.toString().toInt())
                            if (request.isSuccessful) {
                                val posts = request.body() ?: emptyList()
                                val adapter = PostsAdapter(this@SecondActivity,posts)
                                recyclerView.adapter = adapter
                            }
                        }
                    }
                }
            } else {
                throw Throwable("no data found")
            }
        }
    }

    companion object {
        const val POST_ID = "post_id"
    }
}