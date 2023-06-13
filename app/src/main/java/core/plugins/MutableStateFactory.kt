package core.plugins

import core.action.UIAction
import kotlinx.coroutines.flow.MutableStateFlow

interface MutableStateFactory {

    fun createMutableStateFlow(): MutableStateFlow<UIAction>
}