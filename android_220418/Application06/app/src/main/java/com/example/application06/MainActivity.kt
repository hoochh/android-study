package com.example.application06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import com.example.application06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    lateinit var binding:ActivityMainBinding
    var str1=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

        binding.checkBox.setOnCheckedChangeListener(this)
        binding.checkBox2.setOnCheckedChangeListener(this)
        //setContentView(R.layout.activity_main)

//        binding.button.setOnClickListener(View.OnClickListener {
//            binding.textView.setText("버튼1 클릭했어요")
//        })
//        binding.button2.setOnClickListener(View.OnClickListener {
//            binding.textView.setText("버튼2 클릭했어요")
//        })
//        binding.button3.setOnClickListener(View.OnClickListener {
//            binding.textView.setText("버튼3 클릭했어요")
//        })
        binding.checkBox.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            // 람다 함수이기 때문에 매개변수 다음에 바로 구현
            // 원래 형태는 이벤트 핸들러가 존재
            if(b){
                str1+=binding.checkBox.text
            }else{
                str1=str1.replace(binding.checkBox.text.toString(),"")
            }
            binding.textView.setText(str1)
        })
        binding.checkBox2.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if(b){
                str1+=binding.checkBox2.text
            }else{
                str1=str1.replace(binding.checkBox2.text.toString(),"")
            }
            binding.textView.setText(str1)
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            //KeyEvent.KEYCODE_BACK-> Log.d("lyk","Back Button을 눌렀어요")
            KeyEvent.KEYCODE_VOLUME_UP-> Log.d("lyk","Volume_up 버튼을 눌렀어요")
            KeyEvent.KEYCODE_VOLUME_DOWN-> Log.d("lyk","Volume_down 버튼을 눌렀어요")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("lyk","Back Button을 눌렀어요")
    }

    override fun onClick(p0: View?) {
        // TODO("Not yet implement")
        // binding.textView.text="aaaa"
        when(p0){
            binding.button->binding.textView.text="버튼1 클릭"
            binding.button2->binding.textView.text="버튼2 클릭"
            binding.button3->binding.textView.text="버튼3 클릭"
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        //TODO("Not yet implemented")
        when(p0){
            binding.checkBox->{
                if(p1){
                    str1+=binding.checkBox.text
                }else{
                    str1=str1.replace(binding.checkBox.text.toString(),"")
                }
            }

            binding.checkBox2->{
                if(p1){
                    str1+=binding.checkBox2.text
                }else{
                    str1=str1.replace(binding.checkBox2.text.toString(),"")
                }
            }
        }
        binding.textView.setText(str1)
    }
}