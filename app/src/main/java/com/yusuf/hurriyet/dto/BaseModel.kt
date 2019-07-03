package com.yusuf.hurriyet.dto

interface BaseModel {
    val type:Int
    companion object
    {
        const val TYPE_SPOT_IMAGE=1
        const val TYPE_TITLE=2
        const val TYPE_DATE=3
        const val TYPE_EDITOR=4
        const val TYPE_DESCRIPTION=5
        const val TYPE_TEXT=6
        const val TYPE_MAIN_LIST = 7
        const val TYPE_VİEW_PAGE = 8
        const val TYPE_NAV_MENU_CAT = 9
        const val TYPE_NAV_SUB_SETTİNGS=10

    }
}