package com.example.chat


import com.google.gson.annotations.SerializedName

data class Message (
    @SerializedName("content")
    val content : String,

    @SerializedName("login")
    val login : String,

    @SerializedName("date")
    val date : String,

    @SerializedName("id")
    val id : String
)