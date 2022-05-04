package com.example.receiverapp

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.receiverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            when(getIntExtra(BatteryManager.EXTRA_STATUS, -1)){
                BatteryManager.BATTERY_STATUS_CHARGING->{
                    when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                        BatteryManager.BATTERY_PLUGGED_USB-> {
                            binding.tvCharging.text = "USB Plugged..."
                            binding.imageView.setImageResource(R.drawable.usb)
                        }
                        BatteryManager.BATTERY_PLUGGED_AC->{
                            binding.tvCharging.text = "AC Plugged..."
                            binding.imageView.setImageResource(R.drawable.ac)
                        }
                    }
                }
                else ->{
                    binding.tvCharging.text = "Not Plugged..."
                }
            }
            val level=getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale=getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct=level/scale.toFloat()*100
            binding.tvResult.text="$batteryPct%"
        }
        binding.button.setOnClickListener {
            val intent=Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }
    }
}