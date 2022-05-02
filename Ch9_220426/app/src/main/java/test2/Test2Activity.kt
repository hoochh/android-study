package test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ch9_220426.OneFragment
import com.example.ch9_220426.R
import com.example.ch9_220426.TwoFragment
import com.example.ch9_220426.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager
        val trasaction: FragmentTransaction = fragmentManager.beginTransaction()
        var fragment = OneFragment()
        trasaction.add(R.id.container, fragment) // 제일 처음 프래그먼트가 add
        trasaction.commit()

        binding.button2.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val trasaction: FragmentTransaction = fragmentManager.beginTransaction()
            var fragment = OneFragment()
            trasaction.replace(R.id.container, fragment) // 처음 프래그먼트가 현재 프래그먼트로 replace
            trasaction.addToBackStack(null) // 스택을 null로 변경(화면에 보이지 않고 저장 후 다시 이용할 수 있는 기능)
            trasaction.commit()
        }
        binding.button3.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val trasaction: FragmentTransaction = fragmentManager.beginTransaction()
            var fragment = TwoFragment()
            trasaction.replace(R.id.container, fragment)
            trasaction.addToBackStack(null)
            trasaction.commit()
        }
    }
}