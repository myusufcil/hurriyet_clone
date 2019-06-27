package com.yusuf.hurriyet

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusuf.hurriyet.common.constant.IntentBundleConstants
import com.yusuf.hurriyet.dto.Article
import com.yusuf.hurriyet.ui.DetailActivity


class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var Article: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
    override fun getItemCount(): Int = Article.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var item = Article.get(position)

        holder.ID.text = item.Id
        holder.Title.text = item.Title

        if (Article[position].Files.isNotEmpty()) {
            Glide.with(context)
                .load(item.Files[0].FileUrl)
                .apply(RequestOptions().centerCrop())
                .into(holder.FileUrl)
        }

        holder.itemView.setOnClickListener {
            var i = Intent(context, DetailActivity::class.java)

            i.putExtra(IntentBundleConstants.NEWSID.toString(), item.Id)
            context.startActivity(i)

        }
    }

    fun setArticleListItem(Article: List<Article>) {
        this.Article = Article
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {
        val ID: TextView = itemView!!.findViewById(R.id.idx) as TextView
        val FileUrl: ImageView = itemView!!.findViewById(R.id.image) as ImageView
        val Title: TextView = itemView!!.findViewById(R.id.title) as TextView
    }
}