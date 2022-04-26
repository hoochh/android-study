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
        trasaction.add(R.id.container, fragment)
        trasaction.commit()

        binding.button2.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val trasaction: FragmentTransaction = fragmentManager.beginTransaction()
            var fragment = OneFragment()
            trasaction.replace(R.id.container, fragment)
            trasaction.addToBackStack(null)
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