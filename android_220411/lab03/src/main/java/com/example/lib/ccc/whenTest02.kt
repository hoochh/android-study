package com.example.lib.ccc

fun main() {
    var data:Any = 10
    when (data) {
        is String -> println("data is String")
        20, 30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }

    var data2 = 10
    val result = when {
        data2 <= 0 -> "data is <=0"
        data2 > 100 -> "data is >100"
        else -> "data is valid"
    }
    println(result)
}

fun test01(data:Any) {
    when (data) {
        is String -> println("data is String")
        20, 30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }
}

fun test02(data2:Int){
    val result = when {
        data2 <= 0 -> "data is <=0"
        data2 > 100 -> "data is >100"
        else -> "data is valid"
    }
    println(result)
}