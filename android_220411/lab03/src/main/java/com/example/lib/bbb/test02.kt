package com.example.lib

val data1 : Int=10
val data10 = 10 // Int형
// 초기값을 나중에 지정할 때: 기본데이터형이 아닌 오브젝트형(객체형)에서, 나중에 값을 바꿀 수 있는 var의 경우 가능
lateinit var name:String
// lateinit val major:String



class Member(){
    //클래스 내부에서도 변수를 선언할 때 초기값이 있어야 한다.
    var age:Int=10
    var name:String="홍길동"
}

fun main(){
    val data3:Int // 메서드 내부에서는 초기값을 넣지 않아도 데이터형이 정해져 있으면 변수 선언 가능
    //val data4 // 최상위 위치에서 변수 선언시 초기화해주지 않으면 오류 발생
    println("data1:$data1")
    println("data10:$data10")
    data3=5
    println("data3:$data3")
}