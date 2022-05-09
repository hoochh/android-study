package com.example.ch16_220509.test2

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class UserModel (
    var id:String,
    @SerializedName("first_name")
    var firstName:String,
    @SerializedName("last_name")
    var lastName:String,
    var avatar:String,
    @SerializedName("avatar_bitmap")
    var avatarBitmap:Bitmap
)