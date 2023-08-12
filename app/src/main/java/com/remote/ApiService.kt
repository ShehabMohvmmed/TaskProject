package com.remote

import com.remote.model.Comment
import com.remote.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id")id:Int): Response<Post>

    @GET("posts/{id}/comments")
    suspend fun getPostsComments(@Query("id") id: Int): Response<List<Comment>>

}
