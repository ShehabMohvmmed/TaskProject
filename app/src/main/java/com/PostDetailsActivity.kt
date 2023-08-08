package com

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cheesecake.taskproject.R
import com.squareup.picasso.Picasso

class PostDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        val username = intent.getStringExtra("username")
        val date = intent.getStringExtra("date")
        val text = intent.getStringExtra("text")
        val imageUrl = intent.getStringExtra("imageUrl")

        val usernameTextView: TextView = findViewById(R.id.textViewUsername)
        val dateTextView: TextView = findViewById(R.id.textViewDate)
        val textTextView: TextView = findViewById(R.id.textViewText)
        val imageView: ImageView = findViewById(R.id.profileImage)

        usernameTextView.text = username
        dateTextView.text = date
        textTextView.text = text
        Picasso.get()
            .load(imageUrl)
            .into(imageView)


    }
}
