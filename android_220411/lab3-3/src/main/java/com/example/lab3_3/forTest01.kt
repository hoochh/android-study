package com.example.lab3_3

fun main(){
    forTest001()
    println("==================")
    forTest002()
    println("==================")
    forTest003()
    println("==================")
    forTest004()
}

fun forTest001(){
    var sum:Int=0
    for(i in 1..10){
        sum+=i
        println("i=$i, sum=$sum")
    }
}

fun forTest002(){
    var sum=0 //변수형 추론 Int형으로..
    for(i in 1 until 10){
        sum+=i
        println("i=$i, sum=$sum")
    }
}

fun forTest003(){
    var sum:Int=0
    for(i in 2..10 step 2){
        sum+=i
        println("i=$i, sum=$sum")
    }
}

fun forTest004(){
    var sum:Int=0
    for(i in 10 downTo 1){
        sum+=i
        println("i=$i, sum=$sum")
    }
}