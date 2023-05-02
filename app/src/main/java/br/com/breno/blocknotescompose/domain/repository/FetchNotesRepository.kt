package br.com.breno.blocknotescompose.domain.repository

import br.com.breno.blocknotescompose.data.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface FetchNotesRepository {
    suspend fun fetchNotes(): Flow<List<NoteModel>>
}