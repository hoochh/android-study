package com.example.lib.ccc

fun main(){
    val data1 : Array<Int> = Array(3,{0}) // 배열의 크기는 3, 초기화 값은 {0}
    var data2 : IntArray = IntArray(3,{0})
    var data3= intArrayOf(1, 2, 3) // 배열 선언과 초기화를 동시에
    var data4= booleanArrayOf(true, false, true)
    var data5= doubleArrayOf(3.5, 4.5, 3.2, 5.6)

    data1[0]=10
    data1[1]=20
    data1.set(2,30)
    println("array Size:${data1.size}")
    println("array data1:${data1[0]}, ${data1.get(1)}, ${data1[2]}")

    data2[0]=100
    data2[1]=200
    data2.set(2,300)
    println("array Size:${data2.size}")
    println("array data1:${data2[0]}, ${data2.get(1)}, ${data2[2]}")

    for(i in 0..data3.size-1){
        println("data:${data3.get(i)}")
    }
    for(i in 0..data4.size-1){
        println("data:${data4.get(i)}")
    }
    for(i in 0..data5.size-1){
        println("data:${data5.get(i)}")
    }
}