package com.example.lib.ccc

fun main(){
    whenTest01()
    whenTest02()
}

fun whenTest01(){
    var data=10
    when(data){
        10->println("data is 10")
        20->println("data is 20")
        30->println("data is 30")
        else->{
            println("data is not valid data") // switch문의 default 값과 같음
        }
    }
}

fun whenTest02(){
    var data="hello"
    when(data){
        "hello"->println("data is hello")
        "world"-> println("data is world")
        else->{
            println("data is not valid data")
        }
    }
}