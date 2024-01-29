package com.akshay.taskapplication.domain

import com.akshay.taskapplication.model.DataResponse
import retrofit2.http.GET

interface APIInterface {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getData(): List<DataResponse>
}