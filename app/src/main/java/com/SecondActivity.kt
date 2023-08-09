package com

import PostAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.PrefsUtil.Companion.getPrefsUsername
import com.cheesecake.taskproject.R

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView: TextView = findViewById(R.id.txt_username)
        textView.text = getPrefsUsername()
        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val posts = mutableListOf(
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),
            Post("Emad", "2023-08-05", "what a pretty view","https://upload.wikimedia.org/wikipedia/commons/f/fa/Leonardo_DiCaprio_2017.jpg"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),
            Post("Emad", "2023-08-05", "what a pretty view","https://upload.wikimedia.org/wikipedia/commons/f/fa/Leonardo_DiCaprio_2017.jpg"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),
            Post("Emad", "2023-08-05", "what a pretty view","https://upload.wikimedia.org/wikipedia/commons/f/fa/Leonardo_DiCaprio_2017.jpg"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),
            Post("Emad", "2023-08-05", "what a pretty view","https://upload.wikimedia.org/wikipedia/commons/f/fa/Leonardo_DiCaprio_2017.jpg"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),
            Post("Emad", "2023-08-05", "what a pretty view","https://upload.wikimedia.org/wikipedia/commons/f/fa/Leonardo_DiCaprio_2017.jpg"),
            Post("Ahmed", "2023-08-06", "arsenal gonna win tonight","https://upload.wikimedia.org/wikipedia/commons/f/f6/Ryan_Gosling_in_2018.jpg"),

        )

        val adapter = PostAdapter(this,posts)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_second_activity -> openFirstActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openFirstActivity() {
        Log.i( "onCreate: ", PrefsUtil.isLoggedIn.toString())
        PrefsUtil.isLoggedIn = false
        Log.i( "onCreate: ", PrefsUtil.isLoggedIn.toString())
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
