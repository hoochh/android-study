package com.example.ch16_220509.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ch16_220509.R
import com.example.ch16_220509.databinding.ActivityTest3Binding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val url="https://cdn.pixabay.com/photo/2019/08/01/12/36/illustration-4377408_960_720.png"

        Glide.with(this)
            .load(url)
            .override(500,500)
            //.placeholder(R.drawable.loading)
            //.error(R.drawable.error)
            .into(binding.imageView2)
    }
}