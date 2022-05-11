package com.example.ch17_220511

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.ch17_220511.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var manager:LocationManager
    lateinit var binding:ActivityMainBinding

    @SuppressLint("MissingPermission")
    fun getLocation(){
        val location=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        location?.let {
            val latitude=location.latitude
            val longitude=location.longitude
            val accuracy=location.accuracy
            val time=location.time
            binding.textView.text="$latitude, $longitude, $accuracy, $time"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager=getSystemService(LOCATION_SERVICE) as LocationManager

        val permissionLauncher=registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            if(it){
                getLocation()
            }else{
                binding.textView.text="denied....."
            }
        }
        if(ContextCompat.checkSelfPermission(this,"android.permission.ACCESS_FINE_LOCATION")
        ==PackageManager.PERMISSION_GRANTED){
            getLocation()
        }else{
            permissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
        // googleMapActivity -> App18Map 생성하면 지도 앱 생성됨(key가 있어야 함)
        // key 받기 -> <meta-data> 내부에 넣기
    }

    @SuppressLint("MissingPermission")
    override fun onStart() {
        super.onStart()

        val listener:LocationListener = object:LocationListener {
            override fun onLocationChanged(p0: Location) {
                Log.d("lyk","${p0.latitude}, ${p0.longitude}, ${p0.accuracy}")
            }
            override fun onProviderDisabled(provider: String) {
                super.onProviderDisabled(provider)
            }
            override fun onProviderEnabled(provider: String) {
                super.onProviderEnabled(provider)
            }
        }

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10_00L, 10f, listener)
        //manager.removeUpdates(listener)
    }
}