package com.example.application06.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.example.application06.R
import com.example.application06.databinding.ActivityTest2Binding

var data = 0
class Test2Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_test2)

        binding.checkBox3.setOnCheckedChangeListener(MyCheckBoxEventHandeler(binding))
        binding.checkBox4.setOnCheckedChangeListener(MyCheckBoxEventHandeler(binding))
        binding.checkBox5.setOnCheckedChangeListener(MyCheckBoxEventHandeler(binding))
    }
}

class MyCheckBoxEventHandeler(binding: ActivityTest2Binding) : CompoundButton.OnCheckedChangeListener{
    // 주생성자로 binding을 받음

    lateinit var binding: ActivityTest2Binding
    init{
        // 주생성자 binding 초기화
        this.binding=binding
    }
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        // check됨 = true, check 해제됨 = false
        //TODO("Not yet implemented")
        when(p0){
            binding.checkBox3->{
                if(p1){
                    data += 10000
                }else{
                    data -= 10000
                }
            }
            binding.checkBox4->{
                if(p1){
                    data += 20000
                }else{
                    data -= 20000
                }
            }
            binding.checkBox5->{
                if(p1){
                    data += 30000
                }else{
                    data -= 30000
                }
            }
        }
        binding.textView3.text= data.toString()
    }
}

