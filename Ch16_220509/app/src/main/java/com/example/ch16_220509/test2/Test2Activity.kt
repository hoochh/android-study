package com.example.ch16_220509.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch16_220509.R
import com.example.ch16_220509.databinding.ActivityTest2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService=(applicationContext as MyApplication).networkService
        val userListCall=networkService.doGetUserList("2")
        userListCall.enqueue(object: Callback<UserListModel>{
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                val userList = response.body()
                binding.recyclerView1.adapter = MyAdapter(this@Test2Activity, userList?.data)
                //binding.recyclerView2.layout<amager=LinearLayoutManager(this@Test2Activity)
                binding.recyclerView1.addItemDecoration(
                    DividerItemDecoration(this@Test2Activity, LinearLayoutManager.VERTICAL))
            }
            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                call.cancel()
            }

        })
    }
}