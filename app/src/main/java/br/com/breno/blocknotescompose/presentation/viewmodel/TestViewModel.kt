package br.com.breno.blocknotescompose.presentation.viewmodel

import br.com.breno.blocknotescompose.presentation.viewmodel.action.TestViewAction
import core.viewmodel.ActionViewModel

class TestViewModel : ActionViewModel<TestViewAction>() {

    fun teste() {
        sendAction(TestViewAction.Test1)
    }
}