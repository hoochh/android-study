package com.example.lab4.test03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab4.databinding.ActivityTest02Binding
import com.example.lab4.databinding.ActivityTest03Binding

class Test03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityTest03Binding.inflate(layoutInflater)
        // view Binding 활성화 > ActivityTest02Binding 클래스가 자동으로 생성됨
        // inflate(layoutInflater) layoutInflater의 내용을 모두 인스턴스화 함

        setContentView(binding.root)
    }
}