package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.adapter.NewsVideoViewPagerAdapter
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.NewsVideosListDTO

class NewsVideoViewHolder(var view:View):BaseViewHolder(view){
    val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
    override fun bindView(baseModel: BaseModel, position: Int) {

        var item = baseModel as NewsVideosListDTO

      var adapter=  NewsVideoViewPagerAdapter(context = view.context,list = item.list)
        viewPager.adapter=adapter

    }

}