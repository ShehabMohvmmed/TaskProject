package com.remote

import com.remote.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Response<UserResponse>
}
