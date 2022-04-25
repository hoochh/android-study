package com.example.myapplication_220425

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowMetrics
import com.example.myapplication_220425.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            binding.textView1.text = "width : ${windowMetrics.bounds.width()}," +
                    "height : ${windowMetrics.bounds.height()}"
        }else{
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            binding.textView1.text = "width : ${displayMetrics.widthPixels}," +
                    "height : ${displayMetrics.heightPixels}"
        }
    }
}