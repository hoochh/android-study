package com.example.ch9_220426

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ch9_220426.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding // 다른 함수 내에서도 사용하기 위해 이 위치에서 선언..

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // activity가 기본적으로 가지고 있는 Menu 객체를 매개변수로
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuItem1: MenuItem? = menu?.add(0,0,0,"빨강")
        val menuItem2: MenuItem? = menu?.add(0,1,0,"초록")
        val menuItem3: MenuItem? = menu?.add(0,2,0,"파랑")
        // (int groupId, int itemId(고유한 항목, NONE 사용 가능), int order(실행 순서), string titleRes)
        return super.onCreateOptionsMenu(menu) //boolean 값
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        0 ->{
            binding.textView.setTextColor(Color.RED)
            true
        }
        1 ->{
            binding.textView.setTextColor(Color.GREEN)
            true
        }
        2 ->{
            binding.textView.setTextColor(Color.BLUE)
            true
        }else ->{
            super.onOptionsItemSelected(item)
        }

    }
}