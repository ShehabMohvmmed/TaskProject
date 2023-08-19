package com.remoteDataSource

import com.remoteDataSource.model.Comment
import com.remoteDataSource.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<List<Post>>

    @GET("posts/{id}/comments")
    suspend fun getPostsComments(@Path("id") id: Int): Response<List<Comment>>

}
