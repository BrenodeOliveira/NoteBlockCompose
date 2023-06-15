package br.com.breno.blocknotescompose.data.repository

import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.core.testing_base.rules.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchNotesRepositoryImplTest {

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val notesDao: NoteDao = mockk(relaxed = true)
    private val repositoryImpl = FetchNotesRepositoryImpl(notesDao)

    @Test
    fun `When repository is called Should get notes from DB Then return a list of NoteModel`() {
        // Given
        val listNote = listOf(NoteModel(), NoteModel())
        coEvery { notesDao.getAllNotes() } returns flowOf(listNote)
        // When
        coroutineRule.runBlockingTest {
            val result = repositoryImpl.fetchNotes()

            // Then
            assertEquals(listNote, result.first())
        }
    }

}