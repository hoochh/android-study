package com.example.exstudy_220422

// Object class

// singleton Pattern > CarFactory 객체는 딱 한 번만 실행되어 불필요하게 메모리를 사용하지 않도록 함
// 코틀린에서는 object로 싱글톤 패턴을 적용한 클래스를 생성할 수 있음
object CarFactory{
    val cars : MutableList<Car> = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}