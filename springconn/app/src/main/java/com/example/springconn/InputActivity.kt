package com.example.springconn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.springconn.databinding.ActivityInputBinding
import com.example.springconn.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// MainActivity에서 호출
class InputActivity : AppCompatActivity() {
    lateinit var binding:ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var userModel=UserModel(
                id=0,
                username=binding.editId.text.toString(),
                password = binding.editPassword.text.toString(),
                roles = "USER"
            )
            val networkService=(applicationContext as MyApplication).networkService
            //INetworkService 인터페이스 객체화
            val userInsertCall=networkService.insert(userModel)
            userInsertCall.enqueue(object:Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("lyk",response.body().toString())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    call.cancel()
                }
            })
            finish() // onCreate() 이므로 업데이트 되지 않음, MainActivity의 onStart()에 ADD USER 버튼 작성하면 바로 리스트 업데이트 됨
        }
    }
}