package com.example.retrofityt.ui.auth.updateNote

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofityt.model.Note
import com.example.retrofityt.responsitory.NoteResponsitory
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit

class UpdateViewModel(val noteResponsitory: NoteResponsitory) : ViewModel() {
    fun updateNote(note: Note, context: Context){
        viewModelScope.launch {
            val note = noteResponsitory.updateNote(note)
        }
    }
}