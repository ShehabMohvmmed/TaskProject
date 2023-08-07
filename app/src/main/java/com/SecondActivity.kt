package com

import PostAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.MainActivity.Companion.EXTRA_PASSWORD
import com.MainActivity.Companion.EXTRA_SELECTED_GENDER
import com.MainActivity.Companion.EXTRA_SELECTED_LOGIN_METHOD
import com.MainActivity.Companion.EXTRA_SELECTED_SPORTS
import com.MainActivity.Companion.EXTRA_USERNAME
import com.cheesecake.taskproject.R

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val posts = mutableListOf(
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),
            Post("Emad", "2023-08-05", "what a pretty view"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),
            Post("Emad", "2023-08-05", "what a pretty view"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),
            Post("Emad", "2023-08-05", "what a pretty view"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),
            Post("Emad", "2023-08-05", "what a pretty view"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),
            Post("Emad", "2023-08-05", "what a pretty view"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight"),

        )

        val adapter = PostAdapter(posts)
        recyclerView.adapter = adapter
    }


}
