package com.example.exstudy_220422

fun main() {
    // 실행시 main 함수 내부의 코드가 실행됨
//    helloWorld()
//    println(add(4, 9))
//    println(sTemp())
//
//    println(maxBy(1, 2))
//
//    checkNum(1)
//    forAndWhile()
    nullcheck()
} //play 버튼으로 실행 가능

// 1. 함수
fun helloWorld() : Unit{
    // return형이 없을 때 Unit을 써줌(=void), 생략 가능
    println("hello world!")
}

fun add(a: Int, b:Int) : Int{
    // 변수명 : 변수타입 (변수명을 먼저 써준다)
    // 반환값이 있을 경우 반환형 작성 필요
    return a+b
}

// 2. val vs var
// val=value : 값, 바뀌지 않는 것
// var=variable : 바뀌는 값
fun hi() {
    val a: Int = 10
    var b: Int = 9

// a = 100 : 재정의 불가

    val c = 100 // 타입을 적지 않아도 자동으로 추론 해줌 ( val, var는 표기해주어야 함)

    var e : String // 바로 값을 할당하지 않을 때는 타입을 명시해주어야 함
}

// 3. String Template
fun sTemp() {
    val name = "길동"
    val lastname = "홍"
    println("my name is $name I'm 23")
    println("my name is ${name + lastname}")

    println("is this true? ${1==0}")
    println("this is 2\$a")

    // 주석 /**/ 여러 줄 주석
}

// 4. 조건식
// 4-1. if
fun maxBy(a:Int, b:Int):Int {
    if(a > b){
        return a
    }else{
        return b
    }
}
// 다른 방식으로 표현
fun maxBy2(a:Int, b:Int):Int = if(a>b) a else b
// 삼항연산자가 없기 때문에 위와 같이 표현 가능
// 삼항 연산자 : return (a>b)?a:b

// 4-2. when
// switch와 유사한 역할
fun checkNum(score : Int) {
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know") // else는 쓰지 않아도 됨
    }

    // when은 return식으로 쓰일 수도 있을
    // 이 경우에는 else를 반드시 써 주어야 함
    var b:Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b : ${b}")

    // 조건에 범위를 지정할 수 있음
    when(score){
        in 90..100 ->println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("ok")
    }
}

// ++ Expression vs Statement
// Expression : 함수에서 코드를 수행하여 값을 만들어내면 expression
/*
*     when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know") // else는 쓰지 않아도 됨
    }
* */
// 위 when은 값을 만들어내지 않음, 실행만 함(statement)

/*
*     var b:Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b : ${b}")
* */
// 위 when은 return 값을 만들어 냄(b=1 / b=2 / b=3) (expression)

// 코틀린의 모든 함수는 expression 이다 -> 반환값이 명시되지 않은 경우에도 Unit을 리턴하고 있는 것
// 자바의 경우 void 함수는 아무 것도 return하지 않는 statement 함수가 존재
// if문 역시 자바에서는 statement로 만 쓰였지만 코틀린에서는 expression/statement 둘 다로 사용 가능

// 5. Array & List
// Array : 기본적으로 메모리가 할당되어 있음 -> 생성시 크기를 지정해주어야 함

// List
// -List : 수정이 불가능한 list(Immutable, 읽기 전용)
// -MutableList : 수정이 가능한 list(읽기 쓰기 가능)

fun array(){
    val array:Array<Int> = arrayOf(1,2,3)
    val list:List<Int> =listOf(1,2,3)

    // 자동으로 타입 추론 가능
    val array2 = arrayOf(1, "b", 3.4f)
    val list2 = listOf(1, "b", 11L)

    // array는 값의 변경 가능
    array[0] = 3
    // list는 값의 변경 불가능
    // list[0] = 1
    // list는 인터페이스이기 때문에 읽어서 가져오는 것만 가능
    var result = list.get(0)

    // MutableList : 수정이 가능한 list(읽기 쓰기 가능)
    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}

// 6. 반복문 for / while
fun forAndWhile(){
    val students = arrayListOf("AA","BB","CC","DD")

    for(name in students){
        println("${name}")
    }

    for((index:Int, name:String) in students.withIndex()){
        println("${index+1}번째 학생 ${name}")
    }

    var sum:Int=0
    for(i in 10 downTo 1){
        sum += i
        println(sum)
    }
    // 1..10 : 1~10까지 10 포함
    // step 2 : 두 단계마다
    // 10 downTo 1 : 10~1까지 역순으로
    // 1 until 10 : 1~9까지 10 미포함

    var index = 0
    while(index <10){
        println("current index : ${index}")
        index++
    }
}

// 7. Nullable / NonNull
fun nullcheck(){
    // NPE : Null Pointer Exception -> 자바에서 컴파일 시점에서 잡히지 않고 런타임 시점에서 잡히는 에러
    // 코틀린에서는 ? 를 이용해 Null을 잡아냄

    // ? 연산자
    var name : String = "길동" // null이 아닐 때는 타입 생략 가능

    var nullName : String? = null // String은 nonNull 타입이므로 null 값일 때 에러 발생 타입 뒤에 ?를 붙이면 Nullable 타입이 됨(타입 생략 불가능)

    var nameInUpperCase = name.toUpperCase()
    var nullNameInUpperCase :String? = nullName?.toUpperCase() //null이면 null을 반환, null이 아니면 toUpperCase() 실행

    // ?: 엘비스 연산자 : null일 때 디폴트 값을 지정
    val lastName : String? = null
    val fullName = name + " " + (lastName?: "NO lastName") // lastName이 null일 때 디폴트 값 지정
    println(fullName)


}

fun ignoreNulls(str: String?){
    // !! 연산자 : 컴파일시 Null이 아님을 보증해줌
    // null이 아닌 것이 확실하지 않을 때는 사용을 지양.. ? 연산자를 활용하자
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase() // mNotNull 선언시 !! 연산자로 null이 아님을 명시했기 때문에 toUpperCase() 실행시 ?을 표기하지 않아도 에러 발생하지 않음

    // let{} 함수
    val email :String? = "AAA@gmail.com"
    email?.let{ // email이 null이 아니면 let{} 내부로 email 객체를 전달하여 수행
        println("my email is ${email}")
    }
}

