package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import br.com.breno.blocknotescompose.domain.usecase.FetchNotesUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.action.HomeViewAction
import core.viewmodel.ActionViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchNotes: FetchNotesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ActionViewModel<HomeViewAction>() {

    fun getAllNotes() {
        viewModelScope.launch {
            fetchNotes()
                .flowOn(dispatcher)
                .onStart { sendComposable(HomeViewAction.LoadingState(true)) }
                .catch { sendComposable(HomeViewAction.ErrorScreen(true)) }
                .onCompletion { sendComposable(HomeViewAction.LoadingState(false)) }
                .collect{
                    sendComposable(HomeViewAction.ListNotes(it))
                }
        }
    }

    fun navigateToInsert() {
        sendAction(HomeViewAction.NavigateToInsert)
    }
}