package com.yusuf.hurriyet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var Article: List<Article> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = Article.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ID.text = Article.get(position).Id
        holder.Title.text = Article.get(position).Title
        if (Article[position].Files.isNotEmpty()) {
            Glide.with(context)
                .load(Article.get(position).Files[0].FileUrl)
                .apply(RequestOptions().centerCrop())
                .into(holder.FileUrl)
        }
    }

    fun setArticleListItem(Article: List<Article>) {
        this.Article = Article
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val ID: TextView = itemView!!.findViewById(R.id.idx)
        val FileUrl: ImageView = itemView!!.findViewById(R.id.image)
        val Title: TextView = itemView!!.findViewById(R.id.title)

    }

}