package com

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGet: Button
    private lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edtText_Id)
        buttonGet = findViewById(R.id.btn_get)
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        lifecycleScope.launch {
            val api = RetrofitClient.apiService
            if (api.getPosts().isSuccessful) {
                val posts = api.getPosts().body() ?: emptyList()
                val adapter = PostsAdapter(this@MainActivity,posts)
                recyclerView.adapter = adapter

                buttonGet.setOnClickListener {
                    if (editText.text.isNotEmpty()) {
                        lifecycleScope.launch {
                            if (api.getPost(editText.text.toString().toInt()).isSuccessful) {
                                val posts =
                                    listOf(api.getPost(editText.text.toString().toInt()).body()!!)
                                val adapter = PostsAdapter(this@MainActivity,posts)
                                recyclerView.adapter = adapter
                            }
                            Log.i("onCreate: ", posts.toString())
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