package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.ImageDTO

class SpotImageViewHolder (var view: View) : BaseViewHolder(view) {

    var item_spot_image_spot = view.findViewById(R.id.item_spot_image_spot) as ImageView

    override fun bindView(items: BaseModel, position: Int) {

        var item = items as ImageDTO
        Glide.with(view.context).load(item.imageUrl).into(item_spot_image_spot)
    }
}