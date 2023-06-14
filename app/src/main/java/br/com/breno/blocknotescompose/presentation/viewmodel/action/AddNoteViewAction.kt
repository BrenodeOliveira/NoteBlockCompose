package br.com.breno.blocknotescompose.presentation.viewmodel.action

import br.com.breno.core.action.UIAction

sealed class AddNoteViewAction: UIAction {
    object Finish: AddNoteViewAction()
}
