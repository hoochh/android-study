package test003

open class Super(name:String){
    init {
        println("name:$name")
    }
}

// 서브클래스가 주생성자를 가진 경우
class Sub(name:String, count:Int):Super(name){
    // 주생성자는 반드시 호출(name)
    init {
        println("name:$name, count:$count")
    }
}

// 서브클래스가 주생성자를 갖지 않은 경우
class Sub2:Super{
    constructor(name:String):super(name){ // 부모 클래스의 생성자 호출
        println("name:$name")
    }
}

fun main(){
    var super1=Super("홍길동")
    println("===========================")
    var sub=Sub("홍길동", 10)
    println("===========================")
    var sub2=Sub2("홍길동")
}