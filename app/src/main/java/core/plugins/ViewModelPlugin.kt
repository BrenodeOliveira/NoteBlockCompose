package core.plugins

import androidx.annotation.VisibleForTesting

object ViewModelPlugin {

    var factory: LiveDataFactory = DefaultLiveDataFactory()

    @VisibleForTesting
    fun setFactoryPlugin(factory: LiveDataFactory) {
        this.factory = factory
    }
}