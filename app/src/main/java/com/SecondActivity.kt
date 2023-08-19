package com

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.viewModel.SecondViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class SecondActivity : AppCompatActivity() {
    private lateinit var viewModel: SecondViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGet: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]

        editText = findViewById(R.id.edtText_Id)
        buttonGet = findViewById(R.id.btn_get)
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        lifecycleScope.launch {
            try {
                val posts = viewModel.getPosts()
                var adapter = PostsAdapter(this@SecondActivity, posts)
                recyclerView.adapter = adapter

                buttonGet.setOnClickListener {
                    if (editText.text.isNotEmpty()) {
                        lifecycleScope.launch {
                            val posts = viewModel.getPostsByUserId(editText.text.toString().toInt())
                            adapter = PostsAdapter(this@SecondActivity, posts)
                            recyclerView.adapter = adapter
                        }
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this@SecondActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val POST_ID = "post_id"
    }
}