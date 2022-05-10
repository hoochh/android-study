package com.example.springconn

import com.example.springconn.model.UserListModel
import com.example.springconn.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface INetworkService {
    @GET("list")
    fun doGetUserList():Call<UserListModel>

    @GET("user/{id}")
    fun doGetUser(@Path("id") id:Long):Call<UserModel>

    @POST("insert")
    fun insert(@Body user:UserModel):Call<String>
}