package com.akshay.taskapplication.domain.repositories

import com.akshay.taskapplication.model.DataResponse

interface DataRepo {

    suspend fun getData(): List<DataResponse>

}