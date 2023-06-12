
package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.usecase.FetchNotesUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.action.HomeViewAction
import core.rules.TestCoroutineRule
import core.rules.ViewModelTestRule
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val viewModelTestRule = ViewModelTestRule(
        actionObserver = mockk(relaxed = true)
    )

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val fetchNotes = mockk<FetchNotesUseCase>(relaxed = true)
    private val actionObserver: Observer<HomeViewAction> = viewModelTestRule.getActionObserver()
    private lateinit var viewModel: HomeViewModel
    private val dispatcher = Dispatchers.Unconfined

    @Before
    fun setUp() {
        viewModel = HomeViewModel(fetchNotes, dispatcher)
    }

    @Test
    fun `When Navigate to insert is tapped Should send action to navigate`() {
        // When
        viewModel.navigateToInsert()
        // Then
        verify {
            actionObserver.onChanged(HomeViewAction.NavigateToInsert)
        }
    }

    @Test
    fun `getAllNotes Should receive notes When is called`() {
        // Given
        val listNotes = listOf<NoteModel>()
        coEvery  { fetchNotes() } returns flowOf(listNotes)
        // When
        viewModel.getAllNotes()
        // Then
        verify {
            // to be implemented
        }
    }
}
