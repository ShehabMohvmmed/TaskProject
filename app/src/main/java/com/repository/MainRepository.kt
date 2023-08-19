package com.repository

import com.remoteDataSource.AuthApiService
import com.remoteDataSource.RetrofitClient
import com.remoteDataSource.model.LoginRequestBody
import com.remoteDataSource.model.User
import retrofit2.Response

class MainRepository {
    private val authApiService =
        RetrofitClient.getInstance("https://dummyjson.com/").create(AuthApiService::class.java)

    suspend fun login(requestBody: LoginRequestBody): Response<User> {
        return authApiService.login(requestBody)
    }

}