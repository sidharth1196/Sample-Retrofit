package sid.app.retrorecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_item.view.*
import sid.app.retrorecycler.data.Post

class PostAdapter(val context: Context, val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(v : View) : RecyclerView.ViewHolder(v){
        var title : String = ""
        var ID : String = ""
        var view : View = v
        fun bindPost(post : Post){
            title = post.PostTitle
            ID = post.ID
            view.txtPostTitle.text = "${ID}. ${title}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = posts[position]
        holder.bindPost(data)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}