package com.example.retrofityt

import android.app.Application
import com.example.retrofityt.DI.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NoteApplication)
            modules(appModule)
        }
    }
}