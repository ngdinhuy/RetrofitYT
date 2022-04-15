package com.example.retrofityt.responsitory
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofityt.AppConfig
import com.example.retrofityt.adapter.ItemAdapter
import com.example.retrofityt.api.NoteApi
import com.example.retrofityt.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
class NoteResponsitory(val noteApi: NoteApi) {

    suspend fun getListNote() = noteApi.getAllNote()

    suspend fun addNote(note:Note) = noteApi.addNote(note)

    suspend fun updateNote(note: Note) = noteApi.updateNote(note.id,note)
}