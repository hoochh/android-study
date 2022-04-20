package test004

open class Super {
    open var someData=10
    open fun superFun() {
        println("i am superFun:$someData")
    }
}

class Sub: Super() {// 수퍼 클래스의 디폴트 호출, body{ } 생략 가능
    override var someData=20
    override fun superFun(){
        println("i am sub class function:$someData")
    }
}

fun main(){
    val obj = Sub()
    obj.someData=20
    obj.superFun()
}