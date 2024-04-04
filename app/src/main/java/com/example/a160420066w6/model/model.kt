package com.example.a160420066w6.model

data class Manufactures(
    val companyName:String?,
    val country:String?,
)
data class Plane(
    val id:String?,
    val name:String?,
    val manufactures: Manufactures,
    val capaity:Int?,
    val features:String?,
    val url:String?,
)