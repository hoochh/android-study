package com.example.ch12_220504.test1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val dataaa = intent.getStringExtra("data")
        Toast.makeText(context, "receiver data : $dataaa", Toast.LENGTH_SHORT).show()
    }
}