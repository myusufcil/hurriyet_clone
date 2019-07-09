package com.yusuf.hurriyet.adapter.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.common.constant.IntentBundleConstants
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.MainListDTO
import com.yusuf.hurriyet.ui.DetailActivity

class NewsBigCardViewHolder(var view: View) : BaseViewHolder(view) {

    var item_spot_image_spot_activity = view.findViewById(R.id.item_list_big_card_spot_image) as ImageView
    var item_spot_text = view.findViewById(R.id.title) as TextView
    var item_spot_desc_text=view.findViewById(R.id.item_list_big_card_description_text)as TextView

    override fun bindView(baseModel: BaseModel, position: Int) {

        val item = baseModel as MainListDTO
        Glide.with(view.context).load(item.imageUrl)
        .apply(RequestOptions().centerCrop())
        .into(item_spot_image_spot_activity)
        item_spot_text.text = item.title
        item_spot_desc_text.text=item.Description

        view.setOnClickListener {
            val i = Intent(it.context, DetailActivity::class.java)
            i.putExtra(IntentBundleConstants.NEWSID.toString(), item.id)
            it.context.startActivity(i)
        }
    }
}