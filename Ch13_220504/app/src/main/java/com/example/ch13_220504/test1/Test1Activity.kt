package com.example.ch13_220504.test1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.ch13_220504.MyService
import com.example.ch13_220504.R
import com.example.ch13_220504.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest1Binding
    lateinit var serviceBinder:MyService.MyBinder

    val connection=object:ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            serviceBinder=p1 as MyService.MyBinder
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent= Intent(this, MyService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)

        binding.button3.setOnClickListener {
            serviceBinder.funA(10)
        }
        binding.button4.setOnClickListener {
            Log.d("lyk","${serviceBinder.funB(20)}")
        } // 서비스의 데이터를 주고 받음..
    }
}