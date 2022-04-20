package test005

class NonDataClass(val name:String, val age:Int){

}
data class DataClass(val name:String, val age:Int){

}
data class DataClass2(val name:String, val age:Int){
    // equals(), toString() 함수는 보조생성자 데이터 값을 대상으로 삼지 않는다.
    // equals() 함수는 보조생성자가 달라도 주생성자의 데이터 값이 같으면 true 반환
    lateinit var email:String
    constructor(name:String, age:Int, email:String):this(name,age){
        this.email=email
    }
}

fun main(){
    var obj=Super()
    obj.publicData++
    g_publicData++

    var non1=NonDataClass("홍길동",10)
    var non2=NonDataClass("홍길동",10)
    var data1=DataClass("홍길동",10)
    var data2=DataClass("홍길동",10)
    var data3=DataClass2("홍길동", 20, "aaa@bbb.com")
    var data4=DataClass2("홍길동", 20, "ccc@bbb.com")

    println("non data class equals: ${non1.equals(non2)}")
    println("data class equals: ${data1.equals(data2)}")
    println("data class2 equals: ${data3.equals(data4)}")
    println("non1 toString: ${non1.toString()}")
    println("data1 toString: ${data1.toString()}")
    println("data3 toString: ${data3.toString()}")
}