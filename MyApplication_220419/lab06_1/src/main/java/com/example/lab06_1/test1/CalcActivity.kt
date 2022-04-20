package com.example.lab06_1.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lab06_1.R
import com.example.lab06_1.databinding.ActivityCalcBinding
import java.util.*

class CalcActivity : AppCompatActivity(){
    lateinit var binding:ActivityCalcBinding
    lateinit var btnArray:Array<Button> //버튼 배열 생성
    var resultStr=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calc)
        binding= ActivityCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnArray= arrayOf(
            binding.b1, binding.b2, binding.b3, binding.b4, binding.b5,
            binding.b6, binding.b7, binding.b8, binding.b9, binding.b10,
            binding.b11, binding.b12, binding.b13, binding.b14, binding.b15,
            binding.b16, binding.b17, binding.b18, binding.b19, binding.b20,)
        for(i in 0..19){
            btnArray[i].setOnClickListener{
                var result=0.0

                var str1=btnArray[i].text
                when(str1){
                    "="-> {
                        var tokStr = StringTokenizer(resultStr, "+-*/%", true)
                        var num1 = tokStr.nextToken().toDouble()
                        var op = tokStr.nextToken()
                        var num2 = tokStr.nextToken().toDouble()
                        when (op) {
                            "+" -> result = num1 + num2
                            "-" -> result = num1 - num2
                            "*" -> result = num1 * num2
                            "/" -> result = num1 / num2
                            "%" -> result = num1 % num2
                        }
                        binding.textView.setText(result.toString())
                        resultStr = result.toString()
                    }"C"->{
                        resultStr=""
                        binding.textView.setText("0.0")
                    }else->{
                        resultStr+=btnArray[i].text
                        binding.textView.setText(resultStr)
                    }
                }
            }
        }
    }
}