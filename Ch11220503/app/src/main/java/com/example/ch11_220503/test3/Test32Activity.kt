package com.example.ch11_220503.test3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch11_220503.R
import com.example.ch11_220503.databinding.ActivityTest32Binding

class Test32Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest32Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnB.setOnClickListener {
            finish()
        }
        Log.d("Test32Activity","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Test32Activity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Test32Activity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Test32Activity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Test32Activity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Test32Activity","onDestroy")
    }

}