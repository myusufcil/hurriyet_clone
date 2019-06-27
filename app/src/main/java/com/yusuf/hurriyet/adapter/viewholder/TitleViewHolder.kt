package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.TitleDTO

class TitleViewHolder (view: View) : BaseViewHolder(view) {

    var item_title_textview_title = view.findViewById(R.id.item_title_textview_title) as TextView

    override fun bindView(items: BaseModel, position: Int) {

        var item = items as TitleDTO
        item_title_textview_title.text = item.title

    }
}