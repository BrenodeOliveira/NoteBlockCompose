package br.com.breno.blocknotescompose.domain.repository

import br.com.breno.blocknotescompose.data.model.NoteModel

interface AddNoteRepository {

    suspend fun addNote(noteInserted: NoteModel): Long
}