package com.example.retrofityt

import com.example.retrofityt.api.NoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConfig {
    private val BASE_URL="http://10.10.4.237:8080"
    private val builder=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
    val retrofit= builder.build()
    val apiService:NoteApi= retrofit.create(NoteApi::class.java)
}