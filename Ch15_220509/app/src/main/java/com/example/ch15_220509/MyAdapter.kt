package com.example.ch15_220509

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ch15_220509.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas:MutableList<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    =MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val binding=(holder as MyViewHolder).binding
       binding.itemData.text=datas!![position] //null 되면 exception 발생
    }

    override fun getItemCount(): Int {
        return datas?.size ?:0 // data값이 있으면 size 반환, 없으면 0 반환
    }
}