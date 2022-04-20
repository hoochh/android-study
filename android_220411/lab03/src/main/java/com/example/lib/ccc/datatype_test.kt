package com.example.lib.ccc

var data1:Int=10
var data2:Int?=null

val a1:Byte=0b00001010
val a2:Double=5.5
val a3:Float=10.5f
val a4:Long=10L
val a5:Boolean=true
val str1="Hello"
val str2="""
    Hello
    world
    kotlin
"""
var a6:Char='A'

fun someFun(){
    data1=data1+1
    //data2=data2+10
    data2=data1.plus(10)
}

fun main(){
    println("a1:$a1")
    println("a2:$a2")
    println("a3:$a3")
    println("a4:$a4")
    println("a5:$a5")
    println("a6:$a6")
    println("str1:$str1")
    println("str2:$str2")
    println("data1:$data1")
    println("data2:$data2")
    println("someFun()...")
    someFun()
    println("data1:$data1")
    println("data2:$data2")
}