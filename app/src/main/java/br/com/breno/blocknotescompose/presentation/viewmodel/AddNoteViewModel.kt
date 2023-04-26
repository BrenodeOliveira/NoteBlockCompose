package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.usecase.AddNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(private val useCase: AddNoteUseCase) : ViewModel() {

    fun insertNote(title: String, subtitle: String) {
        val noteInserted = stringToModel(title, subtitle)
        viewModelScope.launch {
            useCase.invoke(noteInserted)
        }
    }

    private fun stringToModel(title: String, subtitle: String) =
        NoteModel(title = title, subtitle = subtitle)
}