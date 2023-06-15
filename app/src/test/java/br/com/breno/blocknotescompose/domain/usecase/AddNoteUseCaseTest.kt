package br.com.breno.blocknotescompose.domain.usecase

import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.AddNoteRepository
import br.core.testing_base.rules.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AddNoteUseCaseTest {

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val repository: AddNoteRepository = mockk(relaxed = true)
    private val useCase = AddNoteUseCase(repository)

    @Test
    fun `When useCase is invoke Should return a Long`() {
        // Given
        val noteModel = NoteModel()
        val long = 1L
        coEvery { repository.addNote(noteModel) } returns long
        // When
        coroutineRule.runBlockingTest {
            val result = useCase.invoke(noteModel)

            // Then
            assertEquals(long, result)
        }
     }
}