package com.example.chat

import com.google.gson.annotations.SerializedName

data class SendMessage(
    @SerializedName("content")
    val content : String,

    @SerializedName("login")
    val login : String
)