package com

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.SecondActivity.Companion.POST_ID
import com.cheesecake.taskproject.R
import com.remote.model.Post

class PostsAdapter(private val context: Context,private val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userIdTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val idTextView: TextView = itemView.findViewById(R.id.textViewPostId)
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        private val bodyTextView: TextView = itemView.findViewById(R.id.textViewBody)
        private val buttonComments: TextView = itemView.findViewById(R.id.textViewName)

        fun bind(post: Post) {
            userIdTextView.text = post.userId.toString()
            idTextView.text = post.id.toString()
            titleTextView.text = post.title
            bodyTextView.text = post.body
            buttonComments.setOnClickListener {
                val intent = Intent(context, ThirdActivity::class.java)
                intent.putExtra(POST_ID, idTextView.text.toString())
                context.startActivity(intent)
                Log.i( "bind: ","snjosvnvnojndvjonojv")
            }
        }

    }
}
