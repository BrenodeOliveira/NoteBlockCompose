package br.com.breno.blocknotescompose.presentation.viewmodel.action

import core.action.UIAction

sealed class TestViewAction: UIAction {
    object Test1: TestViewAction()
}
