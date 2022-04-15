package com.example.retrofityt.DI

import com.example.retrofityt.responsitory.remoteModelModule
import org.koin.dsl.module

val appModule = listOf(remoteModelModule, remoteResponsitoryModule )