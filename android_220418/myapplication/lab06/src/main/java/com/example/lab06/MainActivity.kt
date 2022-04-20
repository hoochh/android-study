package com.example.lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.lab06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                Log.d("lyk","Touch down event")
            }
            MotionEvent.ACTION_UP->{
                Log.d("lyk","Touch up event")
            }
            MotionEvent.ACTION_MOVE->{
                binding.tvResult.text="Touch move event x:${event.x}, y:${event.y}"
                //binding.tvResult.text="Touch move event x:${event.rawX}, y:${event.rawY}"
            //Log.d("lyk","Touch move event x:${event.x}, y:${event.y}")
            }
        }
        return super.onTouchEvent(event)
    }
}