package com.example.ch11_220503.test2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch11_220503.R
import com.example.ch11_220503.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        //intent.action="ACTION_VIEW"
        //intent.data= Uri.parse("http://www.google.com")
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.77,127.41"))
                //intent.action="ACTION_EDIT"
            //intent.data= Uri.parse("geo:37.77,127.41")
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}