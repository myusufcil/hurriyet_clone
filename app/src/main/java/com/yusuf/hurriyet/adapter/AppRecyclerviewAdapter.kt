package com.yusuf.hurriyet.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.adapter.viewholder.*

class AppRecyclerviewAdapter(var items: MutableList<BaseModel>) :

    RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): BaseViewHolder {

    var layoutInflater = LayoutInflater.from(parent.context)

        return when(viewType){
            BaseModel.TYPE_SPOT_IMAGE ->
            {
                SpotImageViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_spot_image,
                        parent,
                        false
                    )
                )
            }
            BaseModel.TYPE_TITLE ->
            {
                TitleViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_title,
                        parent,
                        false
                    )
                )
            }
            BaseModel.TYPE_DATE ->{
                DateViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_date,
                        parent,
                        false
                    )
                )
            }
        BaseModel.TYPE_EDITOR ->{
            EditorViewHolder(
                layoutInflater.inflate(
                    R.layout.item_editor,
                    parent,
                    false
                )
            )
        }
        BaseModel.TYPE_DESCRIPTION ->
        {
            DescriptionViewHolder(
                layoutInflater.inflate(
                    R.layout.item_description,
                    parent,
                    false
                )
            )
        }
        BaseModel.TYPE_TEXT -> {
            TextViewHolder(
                layoutInflater.inflate(
                    R.layout.item_text,
                    parent,
                    false
                )
            )
        }

            BaseModel.TYPE_MAIN_LIST -> {
                MainListViewHolder(
                    layoutInflater.inflate(R.layout.item_list,
                        parent,
                        false)
                )
            }

            else ->{
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (items[position].type)
        {
            BaseModel.TYPE_SPOT_IMAGE -> {
                (holder as  SpotImageViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_TITLE -> {
                (holder as  TitleViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_DATE-> {
                (holder as  DateViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_EDITOR-> {
                (holder as  EditorViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_DESCRIPTION-> {
                (holder as  DescriptionViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_TEXT-> {
                (holder as  TextViewHolder).bindView(items[position],position)
            }
            BaseModel.TYPE_MAIN_LIST -> {
                (holder as MainListViewHolder).bindView(items[position],position)
            }
        }
    }
    //**************
    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

}