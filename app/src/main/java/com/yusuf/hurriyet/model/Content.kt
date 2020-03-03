package com.yusuf.hurriyet.model


data class Content(
    val Id: String,
    val Text: String,
    val Files: List<File>,     //file classındaki FileUrl'yi alıyor.
    val Title:String,
    val Description:String,
    val CreatedDate:String,
    val Editor:String)