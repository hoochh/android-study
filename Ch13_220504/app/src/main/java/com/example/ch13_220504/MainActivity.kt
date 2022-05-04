package com.example.ch13_220504

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch13_220504.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent=Intent(this, MyService::class.java)
            startService(intent)
        }
        binding.button2.setOnClickListener {
            val intent=Intent(this, MyService::class.java)
            stopService(intent)
        }
    }
}