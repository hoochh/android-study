package com.example.exstudy_220422

// 코틀린은 파일명과 클래스명이 일치하지 않아도 되고, 한 파일 내부에 여러 개의 클래스가 존재할 수 있다
open class Human constructor(val name :String = "Anonymous"){ // 생성자 내부에서 name을 선언, 디폴트 값 지정 가능. 디폴트값 지정시 빈 생성자도 생성 가능(디폴트 생성자). constructor는 생략 가능
    // 생성자에서 코드블록 실행 불가능
    // init{} : 인스턴스 생성시 실행할 코드를 작성
    // 주생성자의 일부이므로 인스턴스 생성시 자동적으로 실행됨, constructor 블록보다 먼저 실행됨
    init{
        println("New Human has been born!")
    }

    // 클래스 내부에는 프로퍼티, 메소드가 존재
    //val name = "홍길동" : 생성자 내부에서 값을 지정하지 않을 때
    //val name = name // : 생성자에서 name 값을 명시해두었을 때, 생성자 내부에서 선언한 경우 생략 가능

    fun eatingCake() {
        println("this is so yummy")
    }

    // 생성자로 값을 초기화할 수 있음 -> 클래스명 뒤에 constructor(프로퍼티:타입)을 명시해준다

    // 주생성자와 부생성자
    // 자바 클래스의 경우 오버로딩 가능
    /*
    * class Person {
    * public Person(String name) {}
    *
    * public Person(String name, int age) {
    *   this(name);
    * }
    * */

    // 코틀린에서는 부생성자인 constructor 를 이용
    constructor(name:String, age:Int):this(name){ // 주생성자의 위임(주생성자에서 작성한 name)을 상속받아야 함
        println("my name is ${name}, ${age} years old")
    }

    // 클래스 오버라이딩
    open fun singAsong(){
        println("lalala")
    }
}

// 클래스 상속
// 자바의 경우 extends로 상속
// 코틀린에서는 class 클래스명 : 상속받을 클래스() {} 로 상속 받음. 상속은 하나만 상속 받을 수 있음(자바와 마찬가지)
// 코틀린 클래스는 기본적으로 final. 상속받을 클래스는 open class 클래스명() {} 로 명시되어 있어야 함
class Korean : Human(){
    // 클래스 오버라이딩 클래스는 final 이므로 open 키워드를 앞에 붙여주어야 override 가능
    override fun singAsong(){
        super.singAsong() // super를 사용해 원래의 singAsong() 메서드를 실행
        println("랄랄라") // 오버라이딩 한 메서드 실행

        println("my name is : ${name}") // 디폴트값 Anonymous 출력
    }
}


fun main(){
    // 자바에서 클래스 생성시 필요한 new 예약어는 코틀린에서 필요 없음
    val human1 = Human() // : 생성자가 없을 때 or 디폴트 생성자일 때 -> 디폴트값 Anonymous 출력
    println("this human's name is ${human1.name}")
    human1.eatingCake()
    val human2 = Human("홍길순") // : 생성자가 존재할 때
    println("this human's name is ${human2.name}")

    val human3 = Human("홍길석", 32)

    // 클래스 오버라이딩
    val kor = Korean()
    kor.singAsong()
}