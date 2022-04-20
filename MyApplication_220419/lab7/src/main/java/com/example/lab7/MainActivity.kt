package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var flag=false
    var flag2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            if(flag){
                binding.tv1.text=getString(R.string.txt_data1)
                flag=false
            }else{
                binding.tv1.text=getString(R.string.txt_data2)
                flag=true
            }
        }
        binding.button2.setOnClickListener {
            if(flag2){
                binding.imageView.setImageResource(R.drawable.gradient_drawable)
                flag2=false
            }else{
                binding.imageView.setImageResource(R.drawable.drawable_rect)
                flag2=true
            }
        }

            //라디오버튼 체크하여 이미지 출력
//        binding.radioButton4.setOnClickListener{
//            binding.imageView2.setImageResource(R.drawable.cat)
//        }
//        binding.radioButton5.setOnClickListener{
//            binding.imageView2.setImageResource(R.drawable.dog)
//        }
//        binding.radioButton6.setOnClickListener{
//            binding.imageView2.setImageResource(R.drawable.rabbit)
//        }

        //var id=binding.radioGroup.checkedRadioButtonId
        //id 값으로 받아오기
        binding.button3.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButton4->{ //id를 받아와야 하기 때문 binding.radioButton4 은 해당 이름을 가진 view를 가져올 때
                    binding.imageView2.setImageResource(R.drawable.cat)
                }
                R.id.radioButton5->{
                    binding.imageView2.setImageResource(R.drawable.dog)
                }
                R.id.radioButton6->{
                    binding.imageView2.setImageResource(R.drawable.rabbit)
                }
            }
        }
    }
}