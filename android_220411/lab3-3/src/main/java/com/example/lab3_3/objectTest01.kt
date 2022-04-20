package com.example.lab3_3

class User(val name:String, val count:Int){
//    var name:String
//    var count:Int
//
//    init { // init : 주생성자의 body
//        this.name=name
//        this.count=count
//        // 멤버 변수 초기화
//        println("name:$name, count:$count")
//    }
// init 영역에서 멤버 변수를 초기화 하는 방법
// 함수 매개변수에는 var val를 사용할 수 없지만 주생성자의 매개변수에는 사용 가능
// 멤버 변수의 초기화를 대신함

    fun someFun(){
        println("name:$name, count:$count")
        // init 영역에서 멤버 변수를 초기화 하지 않으면 사용 불가
    }
    // 주생성자 안의 값을 전체에서 다 사용하려면 변수를 생성 후 초기화 해주어야 한다.
}

fun main(){
    val user=User("홍길동",10)
    user.someFun()
}