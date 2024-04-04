package com.example.a160420066w6.model

import com.google.gson.annotations.SerializedName

data class Planes(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("manufacturer") val manufacturer: Manufacturer,
    @SerializedName("capacity") val capacity: Int,
    @SerializedName("features") val features: List<String>,
    @SerializedName("images") val images: String
)

data class Manufacturer(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String
)
