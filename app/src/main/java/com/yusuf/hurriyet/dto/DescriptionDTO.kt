package com.yusuf.hurriyet.dto

data class DescriptionDTO (val description:String) :BaseModel{//Data Transfer Object
     override val type:Int
    get() = BaseModel.TYPE_DESCRIPTION
}