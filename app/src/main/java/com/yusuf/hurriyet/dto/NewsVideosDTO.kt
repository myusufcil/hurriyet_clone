package com.yusuf.hurriyet.dto

data class NewsVideosDTO(val title: String,val imageUrl: String) : BaseModel {
    override val type = BaseModel.TYPE_VİEW_PAGE
}