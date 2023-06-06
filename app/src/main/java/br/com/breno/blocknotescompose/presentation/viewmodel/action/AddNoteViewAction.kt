package br.com.breno.blocknotescompose.presentation.viewmodel.action

import core.action.UIAction

sealed class AddNoteViewAction: UIAction {
    object Finish: AddNoteViewAction()
}
