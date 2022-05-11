package com.example.fbtest.model

import java.util.*

data class Message (
    var email:String="",
    var name:String="",
    var message:String="",
    var date: Date =Date(),
    var id:String="",
    var imageUrl:String="",
)
