package com.example.ch11_220503

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch11_220503.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("name")
        val age=intent.getIntExtra("age", 0)

        binding.tvDetail.text="결과: [name: $name, age: $age]"

        binding.btnFinish.setOnClickListener {
            intent.putExtra("resultData", "DetailActivity Result")
            setResult(RESULT_OK, intent)
            // 이 페이지를 열기 위해 intent 정보를 시스템에 보낸 액티비티에 상태정보(RESULT_OK, intent.putExtra())를 전송
            finish() // 다시 MainActivity로 돌아감
        }
    }
}