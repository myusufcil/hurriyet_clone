package com.yusuf.hurriyet.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.hurriyet.dto.BaseModel


abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bindView(baseModel: BaseModel, position: Int)
}