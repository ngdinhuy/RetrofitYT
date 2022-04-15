package com.example.retrofityt.responsitory

import com.example.retrofityt.ui.auth.updateNote.UpdateNoteViewModel
import com.example.retrofityt.ui.auth.updateNote.UpdateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val remoteModelModule = module {
    viewModel { UpdateViewModel( get()) }
}
