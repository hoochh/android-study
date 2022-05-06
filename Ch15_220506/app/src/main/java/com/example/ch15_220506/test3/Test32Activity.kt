package com.example.ch15_220506.test3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch15_220506.databinding.ActivityTest32Binding

class Test32Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest32Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest32Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val shardProf=getSharedPreferences("my_profs", Context.MODE_PRIVATE)

        binding.button4.setOnClickListener {
            val data1=shardProf.getString("data1",null)
            val data2=shardProf.getInt("data2",0)
            Log.d("lyk","$data1, $data2")
        }
        binding.button5.setOnClickListener {
            finish()
        }
    }
}