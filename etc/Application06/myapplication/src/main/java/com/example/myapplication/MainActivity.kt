package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.example.myapplication.databinding.ActivityMainBinding

var data = 0
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.checkBox2.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))
        binding.checkBox3.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))
        binding.checkBox4.setOnCheckedChangeListener(MyCheckBoxEventHandler(binding))

        binding.button.setOnLongClickListener {
            binding.textView2.setText("button Long Click")
            true
        }
    }
}
class MyCheckBoxEventHandler(binding: ActivityMainBinding) : CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMainBinding
    init{
        this.binding=binding
    }
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        // check됨 = true, check 해제됨 = false
        //TODO("Not yet implemented")
        when (p0) {
            binding.checkBox2 -> {
                if (p1) {
                    data += 10000
                } else {
                    data -= 10000
                }
            }
            binding.checkBox3 -> {
                if (p1) {
                    data += 20000
                } else {
                    data -= 20000
                }
            }
            binding.checkBox4 -> {
                if (p1) {
                    data += 30000
                } else {
                    data -= 30000
                }
            }
        }
        binding.textView.text = data.toString()
    }
}