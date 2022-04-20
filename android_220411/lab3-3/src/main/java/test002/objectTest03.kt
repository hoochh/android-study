package test002

class User(name:String){
    init {
        println("name:$name")
    }
    constructor(name:String, count:Int):this(name){
        // 주생성자와 보조생성자가 있을 때, 두 가지를 구분해서 호출할 수 없고 함께 호출해야 함
        // this(name)이라고 적을 경우 name의 초기화는 주생성자가 처리함을 명시
        println("name:$name, count:$count")
    }
    constructor(name: String, count: Int, email:String):this(name, count){
        println("name:$name, count:$count, email:$email")
    }
}
fun main(){
    val user1=User("홍길동") // 주생성자(init)에 의해 초기화
    println("========================================")
    val user2=User("홍길동", 10) // 주생성자와 보조생성자 모두에 의해 초기화
    println("========================================")
    val user3=User("홍길동", 10, "aaa@bbb.com") // 주생성자와 보조생성자 1, 2 모두에 의해 초기화
}