package com.yusuf.hurriyet.network

import com.yusuf.hurriyet.model.Article
import com.yusuf.hurriyet.model.Content
import com.yusuf.hurriyet.model.NewsPhotos
import com.yusuf.hurriyet.model.NewsVideos
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


    @Headers("apikey: 2bfa00b2b9b74a60b255fe6a788e70c0")
    @GET("newsvideos")
    fun getNewsvideos(@Query("\$top") top: Int): Call<List<NewsVideos>>


    @Headers("apikey: 2bfa00b2b9b74a60b255fe6a788e70c0")
    @GET("newsphotogalleries")
    fun getPhotoGallery(@Query("\$top") top: Int): Call<List<NewsPhotos>>

}