package com.example.ch13_220504

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service() {
    class MyBinder:Binder() {
        fun funA(arg:Int){
            Log.d("lyk", "funA...${arg}")
        }
        fun funB(arg:Int):Int{
            Log.d("lyk", "funB...${arg}")
            return arg*100
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }

    override fun onCreate() {
        super.onCreate()
        //Toast.makeText(this, "create service", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast.makeText(this, "destroy service", Toast.LENGTH_SHORT).show()
    }
}