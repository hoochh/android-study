package com.example.exstudy_220422


// data class
// pojo 클래스의 역할
data class Ticket(val companyName :String, val name : String, var date : String, var seatNumber : Int)
// 컴파일시, 각각의 파라미터를 프로퍼티처럼 쓸 수 있고, constructor도 만들어짐
// toString(), hashCode(), equals(), copy() 자동 생성

// java 클래스의 경우
class TicketNormal(val companyName :String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreaAir", "hong", "2020-02-16", 14)
    val ticketB = TicketNormal("koreaAir", "hong", "2020-02-16", 14)

    println(ticketA) // 각 요소 출력
    println(ticketB) // 메모리 주소값 출력
}