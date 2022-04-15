package com.example.retrofityt.ui.auth.updateNote

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.retrofityt.api.NoteApi
import com.example.retrofityt.model.Note
import com.example.retrofityt.responsitory.NoteResponsitory
import kotlinx.coroutines.launch
import org.koin.*
import org.koin.androidx.compose.viewModel
import retrofit2.Call
import retrofit2.Response

class UpdateNoteViewModel():ViewModel() {
    val noteApi=NoteApi.getInstance().create(NoteApi::class.java)
    fun updateNote(note:Note, context: Context){
        viewModelScope.launch {
            val note=noteApi.updateNote(note.id,note)
        }
    }
}