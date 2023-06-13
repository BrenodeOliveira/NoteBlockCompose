package core.plugins

import androidx.annotation.VisibleForTesting

object ViewModelPlugin {

    var actionFactory: LiveDataFactory = DefaultLiveDataFactory()

    @VisibleForTesting
    fun setActionFactoryPlugin(factory: LiveDataFactory) {
        this.actionFactory = factory
    }
}