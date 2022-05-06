package com.example.ch15_220506.test3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch15_220506.databinding.ActivityTest31Binding

class Test31Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest31Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTest31Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val shardProf=getSharedPreferences("my_profs", Context.MODE_PRIVATE)

        binding.button1.setOnClickListener {
            shardProf.edit().run{
                putString("data1","hello")
                putInt("data2",10)
                commit()
            }
        }
        binding.button2.setOnClickListener {
            val data1=shardProf.getString("data1","world")
            val data2=shardProf.getInt("data2", 0)
            Log.d("lyk","$data1, $data2")
        }
        binding.button3.setOnClickListener {
            val intent= Intent(this, Test32Activity::class.java)
            startActivity(intent)
        }

    }
}