package com.example.lab4.test02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lab4.R
import com.example.lab4.databinding.ActivityTest02Binding
import org.w3c.dom.Text

class Test02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_test02)

        val binding=ActivityTest02Binding.inflate(layoutInflater)
        // view Binding 활성화 > ActivityTest02Binding 클래스가 자동으로 생성됨
        // inflate(layoutInflater) layoutInflater의 내용을 모두 인스턴스화 함

        setContentView(binding.root)

        binding.button4.setOnClickListener(View.OnClickListener {
            val id=binding.editTextTextPersonName.text.toString()
            val pw=binding.editTextTextPassword.text.toString()
            val phone=binding.editPhone.text.toString()
            binding.tvResult.setText(id+pw+phone)
        })

//        val button4:Button=findViewById(R.id.button4)
//        val tvResult:TextView=findViewById(R.id.tvResult)
//
//        val etId:EditText=findViewById(R.id.editTextTextPersonName)
//        val etPass:EditText=findViewById(R.id.editTextTextPassword)
//        val etPhone:EditText=findViewById(R.id.editPhone)
//
//        button4.setOnClickListener(View.OnClickListener {
//            val id:String = etId.text.toString()
//            val pass:String = etPass.text.toString()
//            val phone:String = etPhone.text.toString()
//            tvResult.setText("아이디: "+ id + ", 비밀번호: " + pass + ", 전화번호: " + phone)
//        })
    }
}