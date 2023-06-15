package br.com.breno.blocknotescompose.data.repository

import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.core.testing_base.rules.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class AddNoteRepositoryImplTest {

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val notesDao: NoteDao = mockk(relaxed = true)
    private val repositoryImpl = AddNoteRepositoryImpl(notesDao)

    @Test
    fun `When repository is called Should call insert note Then return a long`() {
        // Given
        val noteModel = NoteModel()
        val long = 1L
        coEvery { notesDao.insertNote(noteModel) } returns long
        // When
        coroutineRule.runBlockingTest {
            val result = repositoryImpl.addNote(noteModel)

            // Then
            assertEquals(long, result)
        }
     }
}