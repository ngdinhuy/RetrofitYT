package com.example.retrofityt.ui.auth.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.retrofityt.R
import com.example.retrofityt.model.Note
import com.example.retrofityt.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val noteViewModel= ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        btnAdd.setOnClickListener {
            val note= Note(edt_title.text.toString(),edt_des.text.toString(),"https://s3.cloud.cmctelecom.vn/tinhte2/2019/09/4785764_cover_google-search_tinhte.jpg")
            noteViewModel.addNote(note,requireContext())
        }
    }
}