package lambda

fun main() {
    val some = {no1:Int, no2:Int ->
        println("in lambda function")
        no1*no2
        // return 을 붙이지 않아도 함수의 반환값은 함수 본문의 마지막 표현식
    }

    val some2:(Int, Int)->Int={no1:Int, no2:Int -> no1+no2}
    // 함수의 매개변수 타입(Int, Int)->함수의 반환형 타입 Int

    fun some3(no1:Int, no2:Int):Int{
        return no1+no2
    }

    val some4 = {no1:Int, no2:Int -> no1+no2}

    println("result:${some(10,5)}")
    println("result:${some2(10,20)}")
    println("result:${some3(10,20)}")
}