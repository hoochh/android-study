package com.example.hw220420

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import com.example.hw220420.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.checkBox1.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))
        binding.checkBox2.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))
        binding.checkBox3.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))

        //이미지 변경
        binding.button1.setOnClickListener{
            if(flag){
                binding.imageView.setImageResource(R.drawable.cat1)
                flag=false
            }else{
                binding.imageView.setImageResource(R.drawable.cat2)
                flag=true
            }
        }

        // 등록
        binding.button2.setOnClickListener {
            var id=binding.etTd.text.toString()
            var pw=binding.etPw.text.toString()
            var intro=binding.etIntro.text.toString()
            var gender=""
            var hobby=""


            when(binding.RadioGroup.checkedRadioButtonId){
                R.id.radioButtonM->{
                    gender="남자"
                }
                R.id.radioButtonW->{
                    gender="여자"
                }
            }

            binding.tvResult.setText("아이디 : ${id}\n패스워드 : ${pw}\n성별 : ${gender}\n취미 : ${hobby}\n소개글 : ${intro}")

        }

        //초기화
        binding.button3.setOnClickListener {
            binding.etTd.setText(null)
            binding.etPw.setText(null)
            binding.etIntro.setText(null)
            binding.tvResult.setText(null)
            binding.RadioGroup.clearCheck()

        }
    }
}

class MyCheckBoxEventHandler(binding: ActivityMainBinding) : CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMainBinding
    var hobby1=""
    var hobby2=""
    var hobby3=""
    var hobby=""

    init{
        this.binding=binding
    }
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        //TODO("Not yet implemented")
        when (p0) {
            binding.checkBox1 -> {
                if (p1) {
                    hobby1 += "여행 "
                } else {
                    hobby1 += ""
                }
            }
            binding.checkBox2 -> {
                if (p1) {
                    hobby2 += "게임 "
                } else {
                    hobby2 += ""
                }
            }
            binding.checkBox3 -> {
                if (p1) {
                    hobby3 += "등산 "
                } else {
                    hobby3 += ""
                }
            }
        }
        hobby = hobby1 + hobby2 + hobby3
    }
}