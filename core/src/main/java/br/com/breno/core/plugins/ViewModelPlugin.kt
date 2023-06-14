package br.com.breno.core.plugins

import androidx.annotation.VisibleForTesting

object ViewModelPlugin {

    var actionFactory: LiveDataFactory = DefaultLiveDataFactory()

    @VisibleForTesting
    fun setActionFactoryPlugin(factory: LiveDataFactory) {
        actionFactory = factory
    }
}