package com.yusuf.hurriyet.dto

data class CategoryDTO(val name: String = "") : BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_NAV_MENU_CAT
}

