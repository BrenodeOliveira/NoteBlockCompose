package br.com.breno.blocknotescompose.domain.usecase

import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.repository.FetchNotesRepository
import br.core.testing_base.rules.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchNotesUseCaseTest {

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val fetchNotesRepository: FetchNotesRepository = mockk(relaxed = true)
    private val useCase = FetchNotesUseCase(fetchNotesRepository)

    @Test
    fun `When useCase is invoke Should return a list of note model`() {
        // Given
        val noteModel = listOf(NoteModel(), NoteModel())
        coEvery { fetchNotesRepository.fetchNotes() } returns flowOf(noteModel)
        // When
        coroutineRule.runBlockingTest {
            val result = useCase()

            assertEquals(noteModel, result.first())
        }
     }
}