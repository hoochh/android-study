package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        val tv:TextView=findViewById(R.id.tv)
        val btn: Button=findViewById(R.id.btn1)
        btn.setOnClickListener(View.OnClickListener { 
            tv.setText("버튼을 클릭했음")
        })
    }
}