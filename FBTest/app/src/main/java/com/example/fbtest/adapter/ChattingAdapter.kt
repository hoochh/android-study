package com.example.fbtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fbtest.databinding.ItemMessageBinding
import com.example.fbtest.model.Message
import com.google.firebase.database.core.Context

class MyViewHolder(val binding: ItemMessageBinding):RecyclerView.ViewHolder(binding.root)

class ChattingAdapter(var context: Context, var datas:ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    =MyViewHolder(ItemMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        val user=datas?.get(position)

    }

    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

}
