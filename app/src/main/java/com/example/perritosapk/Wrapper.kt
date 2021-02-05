package com.example.perritosapk

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class WrapperBreed(
    @SerializedName("message")
    val breed : List<String> ,
    @SerializedName("status")
    val status :String
)

data class WrapperImg (
    @SerializedName("message")
    val message :List<String>,
    @SerializedName("status")
    val status: String)





