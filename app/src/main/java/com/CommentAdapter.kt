package com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.model.Comment

class CommentAdapter(private val context: Context,private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        private val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val postIdTextView: TextView = itemView.findViewById(R.id.textViewPostId)
        private val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        private val bodyTextView: TextView = itemView.findViewById(R.id.textViewBody)

        fun bind(comment: Comment) {
            nameTextView.text = comment.name
            postIdTextView.text = comment.postId.toString()
            idTextView.text = comment.id.toString()
            emailTextView.text = comment.email
            bodyTextView.text = comment.body
        }

    }
}
