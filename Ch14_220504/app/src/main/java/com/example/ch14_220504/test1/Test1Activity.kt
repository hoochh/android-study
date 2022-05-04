package com.example.ch14_220504.test1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch14_220504.R
import com.example.ch14_220504.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val cursor=contentResolver.query(Uri.parse("content://provider"),
            null,null,null,null,null)
            var str=""
            while (cursor?.moveToNext()?:false){
                str+=cursor?.getString(0)+"\n"
            }
            binding.textView.text=str
        }
    }
}