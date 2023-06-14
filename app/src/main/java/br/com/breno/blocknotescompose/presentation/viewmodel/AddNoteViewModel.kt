package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.usecase.AddNoteUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.action.AddNoteViewAction
import br.com.breno.core.viewmodel.ActionViewModel
import kotlinx.coroutines.launch

class AddNoteViewModel(private val useCase: AddNoteUseCase) : ActionViewModel<AddNoteViewAction>() {

    fun insertNote(title: String, subtitle: String) {
        val noteInserted = stringToModel(title, subtitle)
        viewModelScope.launch {
            useCase(noteInserted)
            sendAction(AddNoteViewAction.Finish)
        }
    }

    private fun stringToModel(title: String, subtitle: String) =
        NoteModel(title = title, subtitle = subtitle)
}