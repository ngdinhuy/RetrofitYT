package com.example.retrofityt.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofityt.R
import com.example.retrofityt.databinding.ItemBinding
import com.example.retrofityt.model.Note

class ItemAdapter(val context:Context) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    var notes = mutableListOf<Note>()

    class ItemHolder(val itemBinding: ItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(note:Note){
            itemBinding.note=note
        }
    }
    fun setNoteList(movies: List<Note>) {
        this.notes = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ItemBinding.inflate(layoutInflater,parent,false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(notes[position])
        holder.itemBinding.imageButtonDelete.setOnClickListener {
            Toast.makeText(context,"Delete",Toast.LENGTH_SHORT).show()
        }
        val note=notes[position]
        var bundle=Bundle()
        bundle.putSerializable("note",note)
        holder.itemBinding.itemNote.setOnClickListener {    v->
            v.findNavController().navigate(R.id.updateNoteFragment,
                                            bundleOf("note" to note))
        }
    }

    override fun getItemCount(): Int=notes!!.size
}