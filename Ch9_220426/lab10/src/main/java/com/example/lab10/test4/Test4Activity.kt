package com.example.lab10.test4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab10.R
import com.example.lab10.databinding.ActivityTest4Binding

class Test4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.extendFab.setOnClickListener{
            // text가 있을 때 when() 필요
            when(binding.extendFab.isExtended){
                true -> binding.extendFab.shrink()
                false -> binding.extendFab.extend()
            }

            // text가 없을 때는 when() 필요 없음
            binding.tvResult.text="aaaa"

        }

        binding.navBar.setNavigationItemSelectedListener {
            when(it.title){
                // 각 item마다 다른 기능을 줄 때 when 사용, true를 리턴해야 함
                "item1" -> {
                    binding.tvResult.text="아이템1"
                    true
                }
                "item2" -> {
                    binding.tvResult.text="아이템2"
                    true
                }
                "item3" -> {
                    binding.tvResult.text="아이템3"
                    true
                }
                "item4" -> {
                    binding.tvResult.text="아이템4"
                    true
                }
            }
            // when() 혹은 아래와 같이...
            //binding.tvResult.text="${it.title}"
            binding.drawer.closeDrawer(binding.navBar)
            true
        }
    }
}