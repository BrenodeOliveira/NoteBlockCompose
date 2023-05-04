package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.breno.blocknotescompose.domain.usecase.FetchNotesUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.action.MainViewAction
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchNotes: FetchNotesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val mutableState = MutableStateFlow<MainViewAction>(MainViewAction.NavigateToInsert)
    val state = mutableState.asStateFlow()

    private val _actions: MutableLiveData<MainViewAction> = MutableLiveData()
    val actions: LiveData<MainViewAction> = _actions

    fun getAllNotes() {
        viewModelScope.launch {
            fetchNotes()
                .flowOn(dispatcher)
                .onStart { mutableState.value = MainViewAction.LoadingState(true) }
                .catch { mutableState.value = MainViewAction.ErrorScreen(true) }
                .onCompletion { mutableState.value = MainViewAction.LoadingState(false) }
                .collect{
                    mutableState.value = MainViewAction.ListNotes(it)
                }
        }
    }

    fun navigateToInsert() {
        _actions.value = MainViewAction.NavigateToInsert
    }
}