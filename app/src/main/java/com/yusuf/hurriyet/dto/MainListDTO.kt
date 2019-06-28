package com.yusuf.hurriyet.dto

data class MainListDTO(val id:String,val title: String,val imageUrl: String,val Description:String) : BaseModel {
    override val type = BaseModel.TYPE_MAIN_LIST
}