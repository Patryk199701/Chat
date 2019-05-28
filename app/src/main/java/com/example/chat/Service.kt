package com.example.chat


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @GET("messages")
    fun getMessages(): Call<MutableList<Message>>

    @POST("message")
    fun sendMessage(@Body b: SendMessage): Call<Message>

    companion object {

        private const val BaseUrl = "http://tgryl.pl/shoutbox/"

        fun create(): Service {
            val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Service::class.java)
        }
    }
}