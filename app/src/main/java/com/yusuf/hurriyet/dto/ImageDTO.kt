package com.yusuf.hurriyet.dto

data class ImageDTO(var imageUrl: String) : BaseModel{//Data Transfer Object
    override val type = BaseModel.TYPE_SPOT_IMAGE
}

