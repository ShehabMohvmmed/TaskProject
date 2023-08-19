package com.remoteDataSource

import com.remoteDataSource.model.LoginRequestBody
import com.remoteDataSource.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun login(@Body requestBody: LoginRequestBody): Response<User>
}