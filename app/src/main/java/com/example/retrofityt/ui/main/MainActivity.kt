package com.example.retrofityt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofityt.R
import com.example.retrofityt.responsitory.NoteResponsitory
import org.koin.androidx.compose.viewModel

class MainActivity : AppCompatActivity() {
//    URL="https://api.agify.io/?name=meelad"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}