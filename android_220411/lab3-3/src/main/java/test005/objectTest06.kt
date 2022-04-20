package test005

var g_publicData=100
private var g_privateData=200

open class Super{
    var publicData=10
    protected var protectedData=20
    private var privateData=30
}

class Sub:Super(){ // 디폴트 생성자 호출
    fun subFun(){
        publicData++
        protectedData++
        //privateData++ // 클래스 내부에서만 사용 가능
        g_publicData++ // 최상위 멤버인 경우 사용 가능
        g_privateData++
    }
}