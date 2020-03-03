package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.adapter.NewsPhotoViewPagerAdapter
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.NewsPhotosListDTO

class NewsPhotoViewHolder(var view: View): BaseViewHolder(view){
    val viewPager = view.findViewById<ViewPager>(R.id.viewPage_Photo)
    override fun bindView(baseModel: BaseModel, position: Int) {

        var item = baseModel as NewsPhotosListDTO

        var adapter=  NewsPhotoViewPagerAdapter(context = view.context,listPhoto = item.list)
        viewPager.adapter=adapter

    }

}