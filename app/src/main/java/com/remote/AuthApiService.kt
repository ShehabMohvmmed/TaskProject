package com.remote

import com.remote.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun login(@Body requestBody: Map<String,String>): Response<User>
}