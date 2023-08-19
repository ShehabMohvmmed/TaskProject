package com.viewModel

import androidx.lifecycle.ViewModel
import com.remoteDataSource.model.Post
import com.repository.SecondRepository
import retrofit2.Response

class SecondViewModel : ViewModel() {
    private val repository = SecondRepository()

    suspend fun getPosts(): List<Post> {
        return repository.getPosts()
    }

    suspend fun getPostsByUserId(id: Int): List<Post> {
        return repository.getPostsByUserId(id)
    }
}