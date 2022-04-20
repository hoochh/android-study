package test00

class User{
    // 보조생성자
    constructor(name:String){
        println("constructor(name:String) call... $name")
    }

    constructor(name:String, count:Int){
        println("constructor(name:String, count:Int) call... $name, $count")
    }
}

fun main(){
    val user1=User("홍길동")
    val user2=User("홍길동", 10)
}