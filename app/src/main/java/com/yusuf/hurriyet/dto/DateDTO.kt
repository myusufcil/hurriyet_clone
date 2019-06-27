package com.yusuf.hurriyet.dto

data class DateDTO(var date:String): BaseModel{//Data Transfer Object
        override val type:Int
            get() = BaseModel.TYPE_DATE
}
