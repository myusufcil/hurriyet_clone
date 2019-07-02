package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.CategoryDTO

class CategoryViewHolder (view: View): BaseViewHolder(view){

    var title = view.findViewById<TextView>(R.id.item_category_title)
    override fun bindView(items: BaseModel, position: Int) {
        var item = items as CategoryDTO
        title.text = item.name
    }
}