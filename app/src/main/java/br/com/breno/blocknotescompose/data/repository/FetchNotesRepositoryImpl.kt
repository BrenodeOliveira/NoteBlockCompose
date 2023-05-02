package br.com.breno.blocknotescompose.data.repository

import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.FetchNotesRepository
import kotlinx.coroutines.flow.Flow

class FetchNotesRepositoryImpl(private val notesDao: NoteDao): FetchNotesRepository {
    override suspend fun fetchNotes(): Flow<List<NoteModel>> {
        return notesDao.getAllNotes()
    }
}