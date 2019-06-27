package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.EditorDto


class EditorViewHolder (view: View) : BaseViewHolder(view) {
    var item_editor_textview_editor=view.findViewById(R.id.item_editor_textview_editor) as TextView
    override fun bindView(items: BaseModel, position: Int) {

        var item = items as EditorDto
        item_editor_textview_editor.text=item.editor

    }

}