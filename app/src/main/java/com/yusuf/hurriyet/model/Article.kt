package com.yusuf.hurriyet.model

data class Article(val Id: String,
                   val Files: List<File>,//file classındaki FileUrl'yi alıyor.
                   val Title:String,
                   val Description:String,
                   val CreatedDate:String,
                   val Url:String)