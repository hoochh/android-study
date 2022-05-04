package com.example.ch12_220504.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch12_220504.R
import com.example.ch12_220504.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent= Intent(this, MyReceiver::class.java)
            intent.putExtra("data", "Service test")
            sendBroadcast(intent)
        }
    }
}