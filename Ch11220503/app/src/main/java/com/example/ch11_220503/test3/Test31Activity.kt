package com.example.ch11_220503.test3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.ch11_220503.R
import com.example.ch11_220503.databinding.ActivityTest31Binding

class Test31Activity : AppCompatActivity() {
    var count=0
    lateinit var binding:ActivityTest31Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTest31Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener {
            val intent= Intent(this, Test32Activity::class.java)
            startActivity(intent)
        }

        binding.btnCount.setOnClickListener {
            count++
            binding.tvCount.text="count: $count"
        }
        // 화면 회전시 앱이 새로 생성되어 데이터가 사라짐

    }
    // 데이터 값을 유지하려면 Bundle 객체 필요
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }// 화면이 종료될 때 count 변수 값을 state에 저장

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val data=savedInstanceState.getInt("count")
        binding.tvCount.text="count:$data"
        count=data
    }// 화면이 다시 restore 되면 state에 저장된 count 변수 값을 data에 가져와 뿌려줌
}