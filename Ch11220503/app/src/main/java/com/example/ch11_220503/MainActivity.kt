package com.example.ch11_220503

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch11_220503.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent=Intent(this, DetailActivity::class.java)

            intent.putExtra("name", "홍길동")
            intent.putExtra("age", 20)

            //startActivity(intent) // 사후 처리 없이 그냥 액티비티 연결로 끝
            startActivityForResult(intent, 100) // 사후 처리 필요할 때
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode==Activity.RESULT_OK) {
            binding.tvMain.text=data?.getStringExtra("resultData")
        }
    }
}