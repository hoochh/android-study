package com.example.ch16_220509.test2

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ch16_220509.R
import com.example.ch16_220509.databinding.ItemRetrofitBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewHolder(val binding: ItemRetrofitBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val context: Context, val datas:List<UserModel>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        =MyViewHolder(ItemRetrofitBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        val user=datas?.get(position) // 한 개의 데이터 가져옴
        binding.tvId.text=user?.id
        binding.tvFirstName.text=user?.firstName
        binding.tvLastName.text=user?.lastName

//        user?.avatar?.let { //image 주소만 가져와서 하나씩 요청 -> binding
//            val avatarImageCall=(context.applicationContext as MyApplication).networkService
//                .getAvatarImage(it)
//            avatarImageCall.enqueue(object:Callback<ResponseBody>{
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if(response.isSuccessful){
//                        if(response.body()!=null){
//                            val bitmap=BitmapFactory.decodeStream(response.body()!!.byteStream()) // 이미지 생성
//                            binding.imageView.setImageBitmap(bitmap)
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    call.cancel()
//                }
//
//            })
//        }
        Glide.with(context.applicationContext as MyApplication)
            .load(user?.avatar)
            .override(500,500)
            //.placeholder(R.drawable.loading)
            //.error(R.drawable.error)
            .into(binding.imageView)
    }

    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

}