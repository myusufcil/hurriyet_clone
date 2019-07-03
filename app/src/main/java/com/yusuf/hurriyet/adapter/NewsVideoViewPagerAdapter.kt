package com.yusuf.hurriyet.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.yusuf.hurriyet.dto.NewsVideosDTO
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yusuf.hurriyet.R


class NewsVideoViewPagerAdapter(var context: Context,var list: List<NewsVideosDTO>):PagerAdapter()
{
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.news_video_view_page, container, false) as ViewGroup

        var item= list[position]

        var textView = layout.findViewById<TextView>(R.id.news_video_view_page_title_text)
        val imageView:ImageView = layout.findViewById(R.id.news_video_view_page_image_view)
        textView.text=item.title
        Glide.with(context).load(item.imageUrl).into(imageView)
        container.addView(layout)
        return layout
    }
    override fun getCount()= list.size
}