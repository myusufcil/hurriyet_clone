package com.yusuf.hurriyet.dto

data class TitleDTO(var title: String) : BaseModel{//Data Transfer Object
    override val type = BaseModel.TYPE_TITLE
}