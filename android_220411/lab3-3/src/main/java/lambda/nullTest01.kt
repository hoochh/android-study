package lambda

fun main(){
    var data:String? = "abcd"
    val length=if(data==null){
        0
    }else{
        data.length
    }
    println("data length: $length")
    
    var data2:String?="코틀린"
    println("data length: ${data2?.length?:0}")

    var data3:String?="kkkkk"
    var length2 = data3?.length
    println("length32:$length2")

    var data4:String?="park"
    println("data4=${data4?.length?:-1}") //?:-1 의 1은 data4 값이 null일 때 사용할 값
    data4=null
    println("data4=${data4?.length?:-1}")

    println(some("park"))
    println(some(null))
}

fun some(data:String?):Int{
    return data!!.length // 데이터 값이 null일 때 nullPointException 예외를 발생시킴
}