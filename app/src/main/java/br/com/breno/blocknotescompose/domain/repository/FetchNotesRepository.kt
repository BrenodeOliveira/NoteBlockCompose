package br.com.breno.blocknotescompose.domain.repository

import br.com.breno.blocknotescompose.data.model.NoteModel

interface FetchNotesRepository {
    suspend fun fetchNotes(): List<NoteModel>
}