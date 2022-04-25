package com.example.reservationapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.reservationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 날짜 시간 앱 만들기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // time result 변수 선언
        var selectYear:Int=0
        var selectMonth:Int=0
        var selectDay:Int=0
        var selectHour:Int=0
        var selectMinute:Int=0

        // 시작 전-예약완료 버튼 비활성화
        binding.btnEnd.isEnabled=false

        // 기본 뷰-캘린더
        binding.radioCalendar.isChecked=true
        binding.calendarView.visibility=View.VISIBLE
        binding.timePicker.visibility=View.INVISIBLE

        // radioCalendar 체크시-캘린더
        binding.radioCalendar.setOnClickListener {
            binding.calendarView.visibility=View.VISIBLE
            binding.timePicker.visibility=View.INVISIBLE
        }
        // radioTime 체크시-시계
        binding.radioTime.setOnClickListener {
            binding.calendarView.visibility=View.INVISIBLE
            binding.timePicker.visibility=View.VISIBLE
        }

        // 시작 버튼 클릭-타이머 동작, 색상 바뀜, 시작 버튼 비활성화/종료버튼 활성화
        binding.btnStart.setOnClickListener {
            binding.chronometer.base= SystemClock.elapsedRealtime()
            binding.chronometer.start()
            binding.chronometer.setTextColor(Color.RED)
            binding.btnEnd.isEnabled=true
            binding.btnStart.isEnabled=false
        }

        // 달력 선택 후 변수에 값 할당
        binding.calendarView.setOnDateChangeListener {
                calendarView, year, month, dayOfMonth ->
            selectYear=year
            selectMonth=month+1
            selectDay=dayOfMonth
        }

        // 시계 선택 후 변수에 값 할당
        binding.timePicker.setOnTimeChangedListener {
                timePicker, hour, minute ->
            selectHour=hour
            selectMinute=minute
        }

        // 완료 버튼 클릭-타이머 종료, 색상 변경, 시작 버튼 활성화/종료버튼 비활성화
        binding.btnEnd.setOnClickListener {
            binding.tvResult.setText("${selectYear}년 ${selectMonth}월 ${selectDay}일 ${selectHour}시 ${selectMinute}분")
            binding.chronometer.stop()
            binding.chronometer.setTextColor(Color.BLUE)
            binding.btnStart.isEnabled=true
            binding.btnEnd.isEnabled=false
        }
    }
}