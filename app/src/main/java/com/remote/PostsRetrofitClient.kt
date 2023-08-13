package com.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostsRetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: PostsApiService = retrofit.create(PostsApiService::class.java)
}