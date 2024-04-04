package com.example.a160420066w6.model

import com.google.gson.annotations.SerializedName

data class Manufactures(
    val companyName:String?,
    val country:String?,
)
data class Planes(
    val id:String?,
@SerializedName("name")
    val name:String?,
    val manufactures: Manufactures,
    val capaity:Int?,
    val features:String?,
    @SerializedName("images")
    val url:String?,
)