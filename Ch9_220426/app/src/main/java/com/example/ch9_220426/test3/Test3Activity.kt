package com.example.ch9_220426.test3

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch9_220426.R
import com.example.ch9_220426.databinding.ActivityTest3Binding
import com.example.ch9_220426.databinding.ItemlinearlayoutBinding

class Test3Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrName = arrayOf("강기동","구주용","김경래","김승현","김은진","박정현","신재경","안영륜","안혜민","우소윤")
        val arrPhone = arrayOf("010-1111-1234","010-1112-1234","010-1113-1234","010-1114-1234","010-1115-1234",
            "010-1116-1234","010-1117-1234","010-1118-1234","010-1119-1234","010-1110-1234")

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=MyAdapter(arrName, arrPhone)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
    }
}
// RecyclerView.ViewHolderrk binding:ActivityItemBinding 객체를 holding
class MyViewHolder(val binding:ItemlinearlayoutBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val arrName:Array<String>, val arrPhone:Array<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemlinearlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        // view 객체 생성시 main으로부터 context가 들어감 -> parent.context 부모로부터 context를 받아서 사용

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding // holder가 MyViewHolder형이면 binding
        binding.tvName.text=arrName[position]
        binding.txPhone.text=arrPhone[position]
    }

    override fun getItemCount(): Int {
        return arrName.size
    }

}