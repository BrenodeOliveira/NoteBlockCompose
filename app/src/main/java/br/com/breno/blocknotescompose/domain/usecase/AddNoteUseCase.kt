package br.com.breno.blocknotescompose.domain.usecase

import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.AddNoteRepository

class AddNoteUseCase(private val repository: AddNoteRepository) {
    suspend operator fun invoke(noteInserted: NoteModel) = repository.addNote(noteInserted)
}