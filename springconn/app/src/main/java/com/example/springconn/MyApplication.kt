package com.example.springconn

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication:Application() {
    var networkService:INetworkService
    val retrofit:Retrofit
    get()=Retrofit.Builder()
        .baseUrl("http://10.100.103.32:8083/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    init {
        networkService=retrofit.create(INetworkService::class.java)
    }
}