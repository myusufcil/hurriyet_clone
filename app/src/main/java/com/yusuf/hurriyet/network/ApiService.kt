package com.yusuf.hurriyet.network

import com.yusuf.hurriyet.dto.Article
import com.yusuf.hurriyet.dto.Content
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //EndPoint's
    @Headers("apikey: 2bfa00b2b9b74a60b255fe6a788e70c0")  //APIKEY
    @GET("articles/{Id}")
    fun getArticleById(@Path("Id") Id: String): Call<Content>


    @Headers("apikey: 2bfa00b2b9b74a60b255fe6a788e70c0")
    @GET("articles")
    fun getArticles(@Query("\$top") top: Int): Call<List<Article>>
}