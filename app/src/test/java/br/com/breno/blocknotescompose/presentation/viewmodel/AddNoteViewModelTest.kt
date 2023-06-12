package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.breno.blocknotescompose.domain.usecase.AddNoteUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.action.AddNoteViewAction
import core.rules.TestCoroutineRule
import core.rules.ViewModelTestRule
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class AddNoteViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val viewModelTestRule = ViewModelTestRule()

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private val useCase: AddNoteUseCase = mockk(relaxed = true)
    private lateinit var viewModel: AddNoteViewModel
    private val actionObserver: Observer<AddNoteViewAction> = viewModelTestRule.getActionObserver()

    @Before
    fun setUp() {
        viewModel = AddNoteViewModel(useCase)
    }

    @Test
    fun `When note is inserted Should send action Finish`() {
        // Given
        val title = "title"
        val subtitle = "subtitle"
        // When
        viewModel.insertNote(title, subtitle)
        // Then
        verify {
            actionObserver.onChanged(AddNoteViewAction.Finish)
        }
    }
}