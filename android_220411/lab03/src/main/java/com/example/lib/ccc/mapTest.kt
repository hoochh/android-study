package com.example.lib.ccc

fun main(){
    var map= mapOf<String, String>(Pair("one", "hello"), "two" to "world")
    // map 불변
    println("${map.get("one")}")
    println("${map.get("two")}")

    var mutableMap = mutableMapOf<String, String>(Pair("one","hello"))
    mutableMap.put("two", "world")
    println("${mutableMap.get("one")}")
    println("${mutableMap.get("two")}")
}