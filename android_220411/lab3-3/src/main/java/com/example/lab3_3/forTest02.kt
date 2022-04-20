package com.example.lab3_3

fun main(){
    collectionForTest01()
    collectionForTest02()
    whileTest()
}

fun collectionForTest01(){
    var data=arrayOf<Int>(10, 20, 30)
    for(i in data.indices){
        print(data[i])
        if(i != data.size-1){
            print(",")
        }
    }
    println()
}

fun collectionForTest02(){
    var data=arrayOf<Int>(10, 20, 30)
    for((index, value) in data.withIndex()){ // index와 value를 함께 가져옴
        println("$index: $value")
    }
}

fun whileTest(){
    var x = 0
    var sum = 0
    while(x<10){
        sum += ++x
        println("x=$x, sum=$sum")
    }
}