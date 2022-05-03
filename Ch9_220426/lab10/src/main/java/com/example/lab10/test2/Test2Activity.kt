package com.example.lab10.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab10.OneFragment
import com.example.lab10.R
import com.example.lab10.ThreeFragment
import com.example.lab10.TwoFragment
import com.example.lab10.databinding.ActivityTest2Binding
import com.google.android.material.tabs.TabLayout

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 변수를 만들지 않고 supportFragmentManager를 사용하여 메소드 체인
        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction= supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
                }
                transaction.addToBackStack(null)
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }

        })
    }
}