package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.DescriptionDTO

class DescriptionViewHolder (view: View): BaseViewHolder(view){

    var item_description_text_desc=view.findViewById(R.id.item_description_text_desc) as TextView

    override fun bindView(items: BaseModel, position: Int) {
        var item = items as DescriptionDTO
        item_description_text_desc.text=item.description
    }
}