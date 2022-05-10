package com.example.springconn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.springconn.adapter.MyAdapter
import com.example.springconn.databinding.ActivityMainBinding
import com.example.springconn.model.UserListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            val intent= Intent(this,InputActivity::class.java)
            startActivity(intent)
        }

        val networkService=(applicationContext as MyApplication).networkService
        val userListCall=networkService.doGetUserList()
        userListCall.enqueue(object:Callback<UserListModel>{
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                if(response.isSuccessful){
                    binding.recyclerView1.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.recyclerView1.adapter= MyAdapter(this@MainActivity, response.body()?.users)
                    binding.recyclerView1.addItemDecoration(
                        DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
                }
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                call.cancel()
            }

        })
    }
}