package com.yusuf.hurriyet.dto

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/4/2020
*/
data class PrefFavoriteDTO(val items: MutableList<PrefFavoriteDTOData>): BaseModel { 
    override val type: Int
        get() = BaseModel.TYPE_VİEW_PHOTO_PAGE
}