package com.example.ch8_220425.test2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.ch8_220425.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button9.setOnClickListener {
            val uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, uri)
            ringtone.play()
        }

        binding.button10.setOnClickListener {
            val vibrator=if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                val manager=getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                manager.defaultVibrator
            }else{
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            }else{
                vibrator.vibrate(500)
            }
        }

        binding.button11.setOnClickListener {
            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder:NotificationCompat.Builder

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel=NotificationChannel("one", "on channel", NotificationManager.IMPORTANCE_LOW)
                channel.description="on description"

                manager.createNotificationChannel(channel)
                builder=NotificationCompat.Builder(this, "one")
            }else{
                builder=NotificationCompat.Builder(this)
            }
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("Title")
            builder.setContentText("내용입니다.")

            manager.notify(11, builder.build())
        }
    }
}