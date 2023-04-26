package br.com.breno.blocknotescompose.data.repository

import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.AddNoteRepository

class AddNoteRepositoryImpl(private val notesDao: NoteDao): AddNoteRepository {
    override suspend fun addNote(noteInserted: NoteModel): Long {
        return notesDao.insertNote(noteInserted)
    }
}
