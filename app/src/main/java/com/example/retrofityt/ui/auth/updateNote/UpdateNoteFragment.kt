package com.example.retrofityt.ui.auth.updateNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.retrofityt.R
import com.example.retrofityt.databinding.FragmentUpdateNoteBinding
import com.example.retrofityt.model.Note
import com.example.retrofityt.responsitory.NoteResponsitory
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateNoteFragment : Fragment() {
    lateinit var updateFragmentBinding : FragmentUpdateNoteBinding
    lateinit var updateNoteViewModel: UpdateNoteViewModel
    val updateViewModel:UpdateViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        updateFragmentBinding = FragmentUpdateNoteBinding.inflate(inflater,container,false)
        val bundle=arguments
        val note=bundle?.getSerializable("note") as Note?
        Toast.makeText(requireContext(),note.toString(),Toast.LENGTH_SHORT).show()
        updateFragmentBinding.note=note
        updateNoteViewModel = ViewModelProvider(requireActivity()).get(UpdateNoteViewModel::class.java)
        return updateFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateFragmentBinding.btnUpdate.setOnClickListener{
            updateViewModel.updateNote(updateFragmentBinding.note!!,requireContext())
            findNavController().navigate(R.id.listNoteFragment)
        }
    }
}