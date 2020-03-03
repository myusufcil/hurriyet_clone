package com.yusuf.hurriyet.dto

import com.yusuf.hurriyet.dto.BaseModel.Companion.TYPE_VİEW_PAGE

data class NewsVideosListDTO(val list: List<NewsVideosDTO>): BaseModel {
    override val type: Int
        get() = TYPE_VİEW_PAGE
}