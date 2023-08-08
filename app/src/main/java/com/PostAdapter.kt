import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Post
import com.PostDetailActivity
import com.cheesecake.taskproject.R
import com.squareup.picasso.Picasso

class PostAdapter(private val context: Context, private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_post, parent, false)
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
        private val profileImageView: ImageView = itemView.findViewById(R.id.profileImage)
        private val usernameTextView: TextView = itemView.findViewById(R.id.textViewUsername)
        private val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        private val textTextView: TextView = itemView.findViewById(R.id.textViewText)
        private val openButton: Button = itemView.findViewById(R.id.openButton)

        init {
            openButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val post = posts[position]
                    openPostDetailActivity(post)
                }
            }
        }

        fun bind(post: Post) {
            Picasso.get()
                .load(post.imageUrl)
                .into(profileImageView)

            usernameTextView.text = post.username
            dateTextView.text = post.date
            textTextView.text = post.text
        }

        private fun openPostDetailActivity(post: Post) {
            val intent = Intent(context, PostDetailActivity::class.java).apply {
                putExtra("username", post.username)
                putExtra("date", post.date)
                putExtra("text", post.text)
                putExtra("imageUrl", post.imageUrl)
            }
            context.startActivity(intent)
        }
    }
}
