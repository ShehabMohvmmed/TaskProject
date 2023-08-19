package com.repository

import com.remoteDataSource.PostsApiService
import com.remoteDataSource.RetrofitClient
import com.remoteDataSource.model.Post
import retrofit2.Response

class SecondRepository {
    private val postApiService =
        RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/").create(
            PostsApiService::class.java
        )

    suspend fun getPosts(): List<Post> {
        return wrap { postApiService.getPosts() }
    }

    suspend fun getPostsByUserId(id: Int): List<Post> {
        return wrap { postApiService.getPostsByUserId(id) }
    }

    private suspend fun <T> wrap(
        requestFun: suspend () -> Response<T>
    ): T {
        return try {
            val request = requestFun()
            if (request.isSuccessful) {
                request.body()!!
            } else {
                throw Exception(request.message().toString())
            }
        } catch (e: Exception) {
            throw Exception(e.message.toString())
        }
    }
}