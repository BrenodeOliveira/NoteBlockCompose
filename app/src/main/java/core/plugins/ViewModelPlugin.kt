package core.plugins

import androidx.annotation.VisibleForTesting

object ViewModelPlugin {

    var actionFactory: LiveDataFactory = DefaultLiveDataFactory()
    var composeFactory: MutableStateFactory = DefaultMutableStateFactory()

    @VisibleForTesting
    fun setActionFactoryPlugin(factory: LiveDataFactory) {
        this.actionFactory = factory
    }

    @VisibleForTesting
    fun setComposeFactoryPlugin(factory: MutableStateFactory) {
        this.composeFactory = factory
    }
}