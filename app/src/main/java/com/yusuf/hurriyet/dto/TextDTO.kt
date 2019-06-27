package com.yusuf.hurriyet.dto

data class TextDTO(val text:String): BaseModel{//Data Transfer Object
    override val type = BaseModel.TYPE_TEXT
}