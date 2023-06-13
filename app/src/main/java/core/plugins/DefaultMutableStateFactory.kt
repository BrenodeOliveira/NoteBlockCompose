package core.plugins

import core.action.ComposableAction
import core.action.UIAction
import kotlinx.coroutines.flow.MutableStateFlow

class DefaultMutableStateFactory : MutableStateFactory {

    override fun createMutableStateFlow(): MutableStateFlow<UIAction> =
        MutableStateFlow(ComposableAction.InitializingCompose)
}