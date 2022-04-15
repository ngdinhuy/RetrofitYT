package com.example.retrofityt.ui.auth.addNote

import androidx.lifecycle.ViewModel
import com.example.retrofityt.model.Note
import com.example.retrofityt.responsitory.NoteResponsitory

class AddNoteViewModel(val noteResponsitory: NoteResponsitory):ViewModel() {
    suspend fun addNote(note: Note){
        noteResponsitory.addNote(note)
    }

}