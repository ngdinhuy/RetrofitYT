package com.example.retrofityt.api

import com.example.retrofityt.model.Note
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NoteApi {
    @GET("/note")
     suspend fun getAllNote():List<Note>
     
    @GET("/note")
    suspend fun getAllNote1(@Body note: Note): Call<List<Note>>

    @POST("/note")
    suspend fun addNote(@Body note: Note): Note

    @PUT("/note/{id}")
    suspend fun updateNote(@Path("id") id:Int, @Body note : Note): Note

    companion object{
        fun getInstance():Retrofit{
            val BASE_URL="http://10.10.4.237:8080"
            val builder= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            val retrofit= builder.build()
            return retrofit
        }
    }
}