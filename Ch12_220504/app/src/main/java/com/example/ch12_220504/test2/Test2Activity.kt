package com.example.ch12_220504.test2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch12_220504.R

class Test2Activity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        receiver=object :BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                when(p1?.action){
                    Intent.ACTION_SCREEN_ON -> Log.d("lyk","screen on")
                    Intent.ACTION_SCREEN_OFF -> Log.d("lyk", "screen off")
                }
            }
        }
        val filter=IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
        }
        registerReceiver(receiver, filter)
    }
    override fun onDestroy(){
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}