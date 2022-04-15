package com.example.retrofityt.DI

import android.widget.RemoteViews
import com.example.retrofityt.api.NoteApi
import com.example.retrofityt.responsitory.NoteResponsitory
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteResponsitoryModule= module{
    single(named("BASE_URL")){ provideBASE_URL()}
    single { provideRetrofit(get(named("BASE_URL"))) }
    single { provideAPI(get()) }
    single { provideNoteResponsitory(get()) }
}

fun provideBASE_URL() = "http://10.10.4.237:8080"

fun provideRetrofit(BASE_URL : String) : Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun provideAPI(retrofit: Retrofit):NoteApi{
    return retrofit.create(NoteApi::class.java)
}

fun provideNoteResponsitory(api: NoteApi):NoteResponsitory{
    return NoteResponsitory(api)
}