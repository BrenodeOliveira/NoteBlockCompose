package br.com.breno.blocknotescompose.data.repository

import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.FetchNotesRepository

class FetchNotesRepositoryImpl(private val notesDao: NoteDao): FetchNotesRepository {
    override suspend fun fetchNotes(): List<NoteModel> {
        return notesDao.getAllNotes()
    }
}