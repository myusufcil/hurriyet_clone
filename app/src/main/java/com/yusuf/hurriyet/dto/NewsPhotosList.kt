package com.yusuf.hurriyet.dto

import com.yusuf.hurriyet.dto.BaseModel.Companion.TYPE_VİEW_PHOTO_PAGE

data class NewsPhotosList(val list: List<NewsPhotoDTO>): BaseModel {
    override val type: Int
        get() = TYPE_VİEW_PHOTO_PAGE
}