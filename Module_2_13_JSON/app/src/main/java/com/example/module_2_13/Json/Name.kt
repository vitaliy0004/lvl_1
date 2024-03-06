package com.example.module_2_13.Json

import com.google.gson.annotations.SerializedName


data class Name(
    @SerializedName("first")  val first: String,
    @SerializedName("last")  val last: String,
    @SerializedName("title") val title: String
)