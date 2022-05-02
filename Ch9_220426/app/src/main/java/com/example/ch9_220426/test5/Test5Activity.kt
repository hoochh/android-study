package com.example.ch9_220426.test5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ch9_220426.R
import com.example.ch9_220426.databinding.ActivityTest5Binding
import com.example.ch9_220426.databinding.ItemPagerBinding

class Test5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val datas=arrayOf(R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10)
        binding.viewPager1.adapter=MyPagerAdapter(datas)
    }
}

// 하나의 아이템 객체를 가짐
class MyPagerViewHolder(val binding: ItemPagerBinding):RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas:Array<Int>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder=MyPagerViewHolder(ItemPagerBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyPagerViewHolder).binding
        binding.imageView2.setImageResource(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}