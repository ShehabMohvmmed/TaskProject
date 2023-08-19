package com.viewModel

import androidx.lifecycle.ViewModel
import com.remoteDataSource.model.LoginRequestBody
import com.remoteDataSource.model.User
import com.repository.MainRepository
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    suspend fun login(requestBody: LoginRequestBody):Response<User> {
        return repository.login(requestBody)
    }
}