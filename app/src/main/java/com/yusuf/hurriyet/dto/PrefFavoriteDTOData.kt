package com.yusuf.hurriyet.dto

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/4/2020
*/
data class PrefFavoriteDTOData(
    val imgUrl:String,
    val description :String,
    val title:String,
    val date:String,
    val id:Int
): BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_VİEW_PHOTO_PAGE
}