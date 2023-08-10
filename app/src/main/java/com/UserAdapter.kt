import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.taskproject.R
import com.remote.model.User

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileImageView: ImageView = itemView.findViewById(R.id.profileImage)
        private val firstnameTextView: TextView = itemView.findViewById(R.id.textViewfirstname)
        private val lastnameTextView: TextView = itemView.findViewById(R.id.textViewlastname)
        private val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val textTextEmail: TextView = itemView.findViewById(R.id.textViewEmail)


        fun bind(user: User) {
            firstnameTextView.text = user.first_name
            lastnameTextView.text = user.last_name
            idTextView.text = user.id.toString()
            textTextEmail.text = user.email
        }

    }
}
