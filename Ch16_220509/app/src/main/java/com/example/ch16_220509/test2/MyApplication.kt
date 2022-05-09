package com.example.ch16_220509.test2

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {
    // 어플리케이션이 종료되어도 다른 모든 어플리케이션에서 사용하기 위해 application 작성
    var networkService:INetworkService
    val retrofit:Retrofit
    get()=Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    init {
        networkService=retrofit.create(INetworkService::class.java)
    }
}