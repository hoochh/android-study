package com.example.reservationapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reservationapp.databinding.ActivityViewerBinding

class ViewerActivity : AppCompatActivity() {
    // 이미지 뷰어 앱 만들기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_viewer)

        lateinit var binding: ActivityViewerBinding
        lateinit var ids: Array<Int>
        lateinit var titles:Array<String>
        var i=0

        // 제목, 이미지 배열 생성
        ids= arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)

        titles= arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "에리느깡 단 베르양", "잠자는 소녀",
        "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서")


        binding = ActivityViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 첫 번째 이미지에서 이전 버튼 비활성화
        binding.btnPrev.isEnabled=false

        // 다음 버튼 클릭
        binding.btnNext.setOnClickListener {
            // 마지막 페이지 아닐 때 이동시 이전버튼 활성화
            binding.btnPrev.isEnabled=true

            // 다음 페이지 이동시 이미지, 제목 변경
            ++i
            binding.title.setText(titles[i])
            binding.imageView.setImageResource(ids[i])

            // 마지막 페이지에서 다음 버튼 비활성화
            if(i == (titles.size)-1){
                binding.btnNext.isEnabled=false
                return@setOnClickListener
            }
        }

        // 이전 버튼 클릭
        binding.btnPrev.setOnClickListener {
            // 첫 페이지 아닐 때 이전버튼 활성화
            binding.btnPrev.isEnabled=true

            // 이전 페이지 이동시 이미지, 제목 변경
            --i
            binding.title.setText(titles[i])
            binding.imageView.setImageResource(ids[i])

            // 첫 번째 페이지일 때 다시 이전 버튼 비활성화
            if(i == 0) {
                binding.btnPrev.isEnabled=false
                return@setOnClickListener
            }
        }
    }
}