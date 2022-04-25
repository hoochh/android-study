package com.example.exstudy_220422

// 1, Lamda
// 람다식은 마치 value 처럼 다룰 수 있는 익명함수이다
// 1) 메소드의 파라미터로 넘겨줄 수가 있음
// 2) return 값으로 사용할 수 있음

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number*number}

val nameAge = {name:String, age:Int ->
    "my name is ${name} I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("홍길동", 25))
    val a = "AA said "
    val b = "BB said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("홍길동",27))
    println(calculateGrade(97))

    val lamda = {number:Double -> number == 4.3213}
    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.22}))
}

// 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name:String, age:Int) :String {
    val introduceMyself : String.(Int) -> String ={"I am ${this} and ${it} years old"}
    // this가 가리키는 것은 확장함수를 호출하는 오브젝트(String), 여기서는 name
    // 파라미터가 하나일 때 it 예약어로 사용 가능
    // return에서 String.(Int) = name.introduceMyself(age)
    return name.introduceMyself(age)
}

// 람다의 Return
// 마지막 표현식(한 줄)이 리턴값을 의미
// 파라미터는 여러 개가 존재할 수 있으므로 소괄호로 묶어준다
val calculateGrade : (Int) -> String = {
    //calculateGrade는 String을 반환해주어야 함
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    // double형의 파라미터를 받아 boolean형을 반환하는 람다식을 파라미터로 받아, boolean을 반환하는 invokeLamda() 함수
    return lamda(5.234)
}