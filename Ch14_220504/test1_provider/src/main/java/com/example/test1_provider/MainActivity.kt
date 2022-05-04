package com.example.test1_provider

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test1_provider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val cursor=contentResolver.query(
                Uri.parse("content://provider"),
                null,null,null,null,null)
            var str=""
            while (cursor?.moveToNext()?:false){
                str+=cursor?.getString(0)+"\n"
            }
            binding.textView.text=str
        }
    }
}