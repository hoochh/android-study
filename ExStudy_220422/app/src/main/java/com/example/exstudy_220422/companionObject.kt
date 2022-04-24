package com.example.exstudy_220422

// companion object
// 자바의 static 대신 사용되는 것
// 정적 메서드, 정적 변수 선언시 사용 -> private 프로퍼티, 메서드를 읽어올 수 있도록 함
// 컴패니언 메서드의 이름을 지정할 수도 있고, 상속도 받을 수 있음

class Book private constructor(val id: Int, val name : String){
    companion object BookFactory : idProvider{ //idProvider 인터페이스 상속
    override fun getId() : Int {
        return 444
    }
        val myBook = "new book"
        fun create()=Book(getId(), myBook)
    }
}

interface idProvider {
    fun getId() : Int
}

fun main(){
    val book = Book.BookFactory.create() // companion 이름은 생략 가능

    val bookId = Book.BookFactory.getId()
    val bookName = Book.BookFactory.myBook
    println("${book.id} ${book.name}")
    println("${bookId} ${bookName}")
}