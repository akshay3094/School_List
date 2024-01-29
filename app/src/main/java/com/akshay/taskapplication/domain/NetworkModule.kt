package com.akshay.taskapplication.domain

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    fun getApi(): APIInterface{
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(APIInterface::class.java)
    }
}