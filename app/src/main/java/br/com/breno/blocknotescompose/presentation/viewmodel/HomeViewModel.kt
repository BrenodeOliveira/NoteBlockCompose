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

    private val _mutableState = MutableStateFlow<HomeViewAction>(HomeViewAction.NavigateToInsert)
    val state = _mutableState.asStateFlow()

    fun getAllNotesTest() {
        viewModelScope.launch {
            fetchNotes()
                .flowOn(dispatcher)
                .onStart { _mutableState.value = HomeViewAction.LoadingState(true)  }
                .catch { _mutableState.value = HomeViewAction.ErrorScreen(true) }
                .onCompletion { _mutableState.value = HomeViewAction.LoadingState(false) }
                .collect{
                    _mutableState.value = HomeViewAction.ListNotes(it)
                }
        }
    }

    fun navigateToInsertTest() {
        sendAction(HomeViewAction.NavigateToInsert)
    }
}