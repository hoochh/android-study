package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(View.OnClickListener {
            var num1:Int=binding.editNum1.text.toString().toInt()
            var num2:Int=binding.editNum2.text.toString().toInt()
            binding.tvResult01.setText("결과:${num1+num2}")
        })
        binding.btnSub.setOnClickListener(View.OnClickListener {
            var num1:Int=binding.editNum1.text.toString().toInt()
            var num2:Int=binding.editNum2.text.toString().toInt()
            binding.tvResult01.setText("결과:${num1-num2}")
        })
    }
}