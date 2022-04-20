package com.example.lib.ccc

fun main(){
    ifTest01()
    ifTest02()
    ifTest03()
}

fun ifTest01(){
    var data=10
    if(data>0){
        println("결과: data>0")
    }else{
        println("결과: data<0")
    }
}
fun ifTest02(){
    var score=80
    var str1:String

    if(score>=90){
        str1="A학점"
    }else if(score>=80){
        str1="B학점"
    }else if(score>=70){
        str1="C학점"
    }else{
        str1="F학점"
    }
    println("학점: $str1")
}

// 코틀린 표현식: 결과값을 반환해주는 계산식
fun ifTest03(){
    var data=10
    val result=if(data>0) {
        println("data>0")
        true
    }else{
        println("data<=0")
        false
    }
    println(result)
}