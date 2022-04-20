package com.example.lib.ccc

fun main(){
    var list = listOf<Int>(10, 20, 30)
    //list.add(40) 에러 발생
    println(
        """
           list size:${list.size}
           list data:${list[0]}, ${list[1]}, ${list[2]}
        """
    )

    var mutableList = mutableListOf<Int>(10, 20, 30)
    mutableList.add(3, 40)
    mutableList.add(1, 50)

    for(i in 0..mutableList.size-1){
        println("data[$i]: ${mutableList[i]}")
    }
}