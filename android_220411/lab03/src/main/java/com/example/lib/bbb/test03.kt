package com.example.lib.bbb

val data5 by lazy {
    println("in lazy...")
    10
}

fun main() {
    println("main...")
    println(data5+10)
    println(data5)
}