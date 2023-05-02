package br.com.breno.blocknotescompose.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.breno.blocknotescompose.data.model.NoteModel
import br.com.breno.blocknotescompose.domain.usecase.FetchNotesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchNotes: FetchNotesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _navigate: MutableLiveData<Boolean> = MutableLiveData()
    val navigate: LiveData<Boolean> = _navigate
    val listNote: MutableState<List<NoteModel>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val errorScreen: MutableState<Boolean> = mutableStateOf(false)

    fun getAllNotes() {
        viewModelScope.launch {
            fetchNotes()
                .flowOn(dispatcher)
                .onStart { loading.value = true }
                .catch { errorScreen.value = true }
                .collect{
                    loading.value = false
                    listNote.value = it
                }
        }
    }

    fun navigateToInsert() {
        _navigate.value = true
    }
}