package com.example.retrofityt.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofityt.AppConfig
import com.example.retrofityt.adapter.ItemAdapter
import com.example.retrofityt.api.NoteApi
import com.example.retrofityt.model.Note
import com.example.retrofityt.responsitory.NoteResponsitory
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NoteViewModel(): ViewModel(){
    val noteApi=NoteApi.getInstance().create(NoteApi::class.java)
    val listNote=MutableLiveData<List<Note>>()
    var arrayList=ArrayList<Note>()
    fun getListNote(context: Context){
//        viewModelScope.launch {
//            val noteService = noteApi.getAllNote()
//            noteService.enqueue(object : retrofit2.Callback<List<Note>> {
//                override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
//                    listNote.postValue(response.body())
//                    Toast.makeText(context, "OK", Toast.LENGTH_LONG).show()
//                    for (item in response.body()!!) {
//                        arrayList.add(item)
//                    }
//                    //Toast.makeText(context,arrayList.size.toString(),Toast.LENGTH_LONG).show()
//                }
//
//                override fun onFailure(call: Call<List<Note>>, t: Throwable) {
//                    //Toast.makeText(context,t.toString(),Toast.LENGTH_LONG).show()
//                    Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
//                }
//
//            })
//        }
        viewModelScope.launch {
            listNote.postValue(noteApi.getAllNote())
        }
    }

    fun addNote(note: Note,context: Context){
        viewModelScope.launch {
            val noteService=noteApi.addNote(note)
        }
//        Không sử dụng Coroutin
//        noteService.enqueue(obsject : Callback<Note> {
//            override fun onResponse(call: Call<Note>, response: Response<Note>) {
//                Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onFailure(call: Call<Note>, t: Throwable) {
//
//            }
//
//        })
    }
    fun createAdapter(context: Context) = ItemAdapter(context)
}