package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.webkit.WebView
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.TextDTO


class TextViewHolder (view: View) : BaseViewHolder(view) {
    var item_text_textview_content=view.findViewById(R.id.item_text_webView_content)as WebView
    override fun bindView(items: BaseModel, position: Int) {

        var item = items as TextDTO
        item_text_textview_content.loadData(item.text,"text/html; charset=utf-8", "utf-8")

    }
}