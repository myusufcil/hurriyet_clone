package com.yusuf.hurriyet.dto

data class EditorDto(var editor:String): BaseModel{//Data Transfer Object
    override val type = BaseModel.TYPE_EDITOR
}