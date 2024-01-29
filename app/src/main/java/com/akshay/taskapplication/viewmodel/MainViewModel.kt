package com.akshay.taskapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.akshay.taskapplication.domain.repositories.DataRepo
import com.akshay.taskapplication.model.DataResponse
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(val repo: DataRepo) : ViewModel() {

    val dataResponse = MutableStateFlow<List<DataResponse>>(arrayListOf())

    suspend fun getData() {
        val response = repo.getData()
        dataResponse.value = response
    }
}