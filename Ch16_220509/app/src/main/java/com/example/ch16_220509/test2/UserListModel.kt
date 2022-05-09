package com.example.ch16_220509.test2

import com.google.gson.annotations.SerializedName

data class UserListModel(
    var page:String,
    @SerializedName("per_page")
    var perPage:String,
    var total:String,
    @SerializedName("total_pages")
    var totalPages:String,
    var data:List<UserModel>
)