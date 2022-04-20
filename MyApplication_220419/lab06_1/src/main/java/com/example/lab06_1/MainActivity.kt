package com.example.lab06_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.lab06_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var initTime=0L
    var pauseTime=0L //시간 멈춤

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SAM 방식
        binding.btnStart.setOnClickListener{
            binding.chronometer.base=SystemClock.elapsedRealtimeNanos()+pauseTime
            binding.chronometer.start()
            binding.btnStop.isEnabled=true
            binding.btnReset.isEnabled=true
            binding.btnStart.isEnabled=false
        }

        binding.btnStop.setOnClickListener{
            pauseTime=binding.chronometer.base-SystemClock.elapsedRealtimeNanos()
            binding.chronometer.stop()
            binding.btnStop.isEnabled=false
            binding.btnReset.isEnabled=true
            binding.btnStart.isEnabled=true
        }

        binding.btnReset.setOnClickListener{
            pauseTime=0L
            binding.chronometer.base=SystemClock.elapsedRealtimeNanos()
            binding.chronometer.stop()
            binding.btnStop.isEnabled=false
            binding.btnReset.isEnabled=false
            binding.btnStart.isEnabled=true
        }
    }
}