package com.example.ch15_220506.test2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch15_220506.R
import com.example.ch15_220506.databinding.ActivityTest2Binding
import java.lang.Exception
import java.nio.charset.Charset

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWrite.setOnClickListener {
            var outFile=openFileOutput("test1.txt", Context.MODE_APPEND)
            // append : 원래 파일 내용에 새로 입력된 내용이 추가가 됨
            // private : 원래 내용 지워지고 새로운 내용이 입력됨
            var str=binding.edInput.text.toString()
            outFile.write(str.toByteArray())
            outFile.close()
        }

        binding.btnRead.setOnClickListener {
            try {
                var inputFile=openFileInput("test1.txt")
                var txt=ByteArray(inputFile.available()) // inputFile 데이터 크기만큼
                inputFile.read(txt)
                inputFile.close()
                val str=txt.toString(Charsets.UTF_8) //byte 배열로 가져왔으므로 String, utf-8 인코딩으로 변환
                binding.tvRead.setText(str)
            }catch (e:Exception){
                binding.tvRead.setText("파일 없음")
            }
        }
    }
}