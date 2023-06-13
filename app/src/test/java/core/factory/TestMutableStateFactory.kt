package core.factory

import androidx.lifecycle.Observer
import core.action.ComposableAction
import core.action.UIAction
import core.plugins.MutableStateFactory
import kotlinx.coroutines.flow.MutableStateFlow

@Suppress("UNCHECKED_CAST")
class TestMutableStateFactory(val actionObserver: Observer<UIAction>): MutableStateFactory {

    override fun createMutableStateFlow(): MutableStateFlow<UIAction> =
        MutableStateFlow<UIAction>(ComposableAction.InitializingCompose).apply {}
}