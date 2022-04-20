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
        // view Binding 활성화 > ActivityTest02Binding 클래스가 자동으로 생성됨
        // inflate(layoutInflater) layoutInflater의 내용을 모두 인스턴스화 함

        setContentView(binding.root)

        binding.btn1.setOnClickListener(View.OnClickListener {
            val num1=binding.etNum1.text.toString().toInt()
            val num2=binding.etNum2.text.toString().toInt()
            binding.result.setText("결과 : ${num1 + num2}")
        })
        binding.btn2.setOnClickListener(View.OnClickListener {
            val num1=binding.etNum1.text.toString().toInt()
            val num2=binding.etNum2.text.toString().toInt()
            binding.result.setText("결과 : ${num1 - num2}")
        })
        binding.btn3.setOnClickListener(View.OnClickListener {
            val num1=binding.etNum1.text.toString().toInt()
            val num2=binding.etNum2.text.toString().toInt()
            binding.result.setText("결과 : ${num1 * num2}")
        })
        binding.btn4.setOnClickListener(View.OnClickListener {
            val num1=Integer.parseInt(binding.etNum1.text.toString())
            val num2=binding.etNum2.text.toString().toInt()
            binding.result.setText("결과 : ${num1 / num2}, 나머지:${num1 % num2}")
        })
    }
}