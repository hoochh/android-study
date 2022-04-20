package com.example.lab4.test01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lab4.R

class Test01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test01)
        //set...() 뷰를 화면에 보여주고, 뷰를 인스턴스화 함
        val button:Button=findViewById(R.id.btn1)
        val tv=findViewById<TextView>(R.id.tv1)
        button.setOnClickListener(View.OnClickListener{
            tv.setText("Android world")
        })

        var btn1:Button=findViewById(R.id.button5)
        var btn2:Button=findViewById(R.id.button6)
        var btn3:Button=findViewById(R.id.button7)

        var btn10:Button=findViewById(R.id.button05)
        var btn20:Button=findViewById(R.id.button06)
        var btn30:Button=findViewById(R.id.button07)

        btn1.setOnClickListener(View.OnClickListener {
            btn2.visibility=View.INVISIBLE
        })
        btn3.setOnClickListener(View.OnClickListener {
            btn2.visibility=View.VISIBLE
        })
        btn10.setOnClickListener(View.OnClickListener {
            btn20.visibility=View.GONE
        })
        btn30.setOnClickListener(View.OnClickListener {
            btn20.visibility=View.VISIBLE
        })
    }
}