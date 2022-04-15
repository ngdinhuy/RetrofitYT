package com.example.retrofityt.ui.auth.listNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofityt.R
import com.example.retrofityt.databinding.FragmentListNoteBinding
import com.example.retrofityt.viewmodel.NoteViewModel

class ListNoteFragment : Fragment() {
    lateinit var dataBinding:FragmentListNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentListNoteBinding.inflate(inflater,container,false)
        val noteViewModel= ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        var adapter=noteViewModel.createAdapter(requireContext())
        noteViewModel.listNote.observe(this, Observer {
            adapter.setNoteList(it)
        })
        dataBinding.recyclerViewNote.adapter=adapter
        dataBinding.recyclerViewNote.layoutManager= LinearLayoutManager(requireContext())
        noteViewModel.getListNote(requireContext())
        return dataBinding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataBinding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addFragment)
        }
    }
}