package br.com.breno.blocknotescompose.presentation.viewmodel.action

import br.com.breno.blocknotescompose.data.model.NoteModel

sealed class MainViewAction {
    object NavigateToInsert: MainViewAction()
    data class ListNotes(val list: List<NoteModel>): MainViewAction()
    data class LoadingState(val isLoading: Boolean): MainViewAction()
    data class ErrorScreen(val errorScreen: Boolean): MainViewAction()
}