package com.example.ch8_220425.test1

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.ch8_220425.R
import com.example.ch8_220425.databinding.ActivityTest1Binding

class TestActivity1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_test1)

        var binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toast message
        binding.button.setOnClickListener {
            var toast = Toast.makeText(this, "토스트 메시지", Toast.LENGTH_SHORT)
            // 콜백함수는 객체 생성시 호출하지 않아도 자동으로 실행되는 함수
            toast.addCallback(
                object:Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("lyk", "toast hidden")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("lyk", "toast shown")
                    }
                }
            )
            toast.show()
        }

        // DatePickerDialog
        binding.button2.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { //datapicker 뷰가 뜸
                    datePicker, year, month, day ->
                Log.d("lyk", "date:${year}년 ${month+1}월 ${day}일")
                binding.textView.setText("date:${year}년 ${month+1}월 ${day}일")
            }, 2022, 3, 25).show()
        }

        // TimePickerDialog
        binding.button3.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener {
                    timePicker, hour, minute ->
                Log.d("lyk","time: ${hour}시 ${minute}분")
                binding.textView.setText("time: ${hour}시 ${minute}분")
            }, 16, 10, true).show()
        }

        // AlertDialog
        binding.button4.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("test Dialog")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말로 종료하시겠습니까?")
                setPositiveButton("Ok",null)
                setNegativeButton("Cancel",null)
                setNeutralButton("More",null)
                setPositiveButton("Yes", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    binding.textView.setText("Yes 버튼 클릭")
                })
                setNegativeButton("No",null)
                show()
            }
        }

        // List AlertDialog
        binding.button5.setOnClickListener {
            var items= arrayOf<String>("사과","복숭아","수박","포도")
            var str=""

            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(items,
                    booleanArrayOf(false,false,false,false),
                    DialogInterface.OnMultiChoiceClickListener {
                            dialogInterface, i, b ->
                        if(b){
                            str+=items[i]
                        }else{ // false일 때 문자열 지우기
                            str=str.replace(items[i],"")
                        }
                    }
                )
                setPositiveButton("닫기",DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    binding.textView.setText(str)
                })
                show()
            }
        }
    }
}