package com.example.lib

import java.text.SimpleDateFormat
import java.util.*

var data=10 // 값 변경 가능
val data2=20 // 값 변경 불가능

fun formatDate(date: Date):String{ //date : 매개변수, Date : 매개변수의 타입, String : 반환형
    val sdformat=SimpleDateFormat("yyyy-MM-dd") //() 안에 ""입력하면 pattern 자동 생성됨(직접입력 X)
    return sdformat.format(date)
}

class User {
    var name="hello"
    fun sayHello(){

    }
}