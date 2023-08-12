package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.SecondActivity.Companion.POST_ID
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
        val postIdString = intent.getStringExtra(POST_ID)

        lifecycleScope.launch {
            val api = RetrofitClient.apiService
            val request = api.getPostsComments(postIdString!!.toInt())
            if (request.isSuccessful) {
                val comments = request.body() ?: emptyList()
                val adapter = CommentAdapter(this@ThirdActivity,comments)
                recyclerView.adapter = adapter
            } else {
                throw Throwable("no data found")
            }
        }
    }
}