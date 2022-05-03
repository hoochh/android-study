package com.example.lab10.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab10.*
import com.example.lab10.databinding.ActivityTest3Binding
import com.google.android.material.tabs.TabLayoutMediator

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // tab 연결하기
        // adapter 생성
        var adapter1=MyFragmentAdapter(this)
        binding.viewPager.adapter=adapter1

        // 뷰 페이저와 탭 연동
        TabLayoutMediator(binding.tabs,binding.viewPager) { tab, position ->
            tab.text = "Tab${(position + 1)}"
        }.attach()
    }
}
class MyFragmentAdapter(activity:Test3Activity): FragmentStateAdapter(activity) {
    var fragments: List<Fragment>

    init {
        fragments = listOf(Test1Fragment(), Test2Fragment(), Test3Fragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}