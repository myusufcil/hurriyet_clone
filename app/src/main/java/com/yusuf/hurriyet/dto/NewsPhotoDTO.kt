package com.yusuf.hurriyet.dto

data class NewsPhotoDTO(val Description: String,val imageUrl: String) : BaseModel {
    override val type = BaseModel.TYPE_VİEW_PHOTO_PAGE
}