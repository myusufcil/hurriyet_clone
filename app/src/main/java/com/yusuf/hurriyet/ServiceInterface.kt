package com.yusuf.hurriyet


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ServiceInterface {

    @Headers("apikey: 2bfa00b2b9b74a60b255fe6a788e70c0")
    @GET("articles?top=5")
    fun getArticles(): Call<List<Article>>

    companion object {

        var BASE_URL = "https://api.hurriyet.com.tr/v1/"
        fun create(): ServiceInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ServiceInterface::class.java)
        }
    }
}