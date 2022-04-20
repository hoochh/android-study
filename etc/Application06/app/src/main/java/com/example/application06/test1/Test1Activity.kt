package com.example.application06.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.application06.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button4.setOnClickListener(MyEventHandler(binding))
        binding.button7.setOnClickListener(MyEventHandler(binding))
    }
}
class MyEventHandler(binding: ActivityTest1Binding):View.OnClickListener{
    lateinit var binding:ActivityTest1Binding
    init {
        this.binding=binding
    }

    override fun onClick(p0: View?){
        when(p0){
            binding.button4->binding.textView2.text="버튼4 클릭"
            binding.button7->binding.textView2.text="버튼7 클릭"
        }
    }
}