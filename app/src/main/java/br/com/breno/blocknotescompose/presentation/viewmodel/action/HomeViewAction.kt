package br.com.breno.blocknotescompose.presentation.viewmodel.action

import br.com.breno.blocknotescompose.data.model.NoteModel
import core.action.UIAction

sealed class HomeViewAction: UIAction {
    object NavigateToInsert: HomeViewAction()
    data class ListNotes(val list: List<NoteModel>): HomeViewAction()
    data class LoadingState(val isLoading: Boolean): HomeViewAction()
    data class ErrorScreen(val errorScreen: Boolean): HomeViewAction()
}
