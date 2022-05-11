package com.example.springconn.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.springconn.DetailActivity
import com.example.springconn.databinding.ItemBinding
import com.example.springconn.model.UserModel

class MyViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val context: Context, val datas:List<UserModel>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    =MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        val user=datas?.get(position)
        binding.idView.text=user?.username
        binding.idView.setOnClickListener {
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra("id",user?.id) // DetailActivity에 id 데이터 전달
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

}