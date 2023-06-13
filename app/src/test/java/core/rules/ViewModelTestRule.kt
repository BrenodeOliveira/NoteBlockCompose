package core.rules

import androidx.lifecycle.Observer
import core.factory.TestLiveDataFactory
import core.action.UIAction
import core.plugins.DefaultLiveDataFactory
import core.plugins.ViewModelPlugin
import io.mockk.mockk
import org.junit.rules.ExternalResource

@Suppress("UNCHECKED_CAST")
class ViewModelTestRule(
    actionObserver: Observer<UIAction> = mockk(),
    composeObserver: Observer<UIAction> = mockk(),
) : ExternalResource() {
    private val actionFactory = TestLiveDataFactory(actionObserver, composeObserver)

    fun <T : UIAction> getActionObserver(): Observer<T> {
        try {
            return actionFactory.actionObserver as Observer<T>
        } catch (e: UninitializedPropertyAccessException) {
            throw Throwable("Not initialized")
        }
    }

    fun <T : UIAction> getComposeObserver(): Observer<T> {
        try {
            return actionFactory.composeObserver as Observer<T>
        } catch (e: UninitializedPropertyAccessException) {
            throw Throwable("Not initialized")
        }
    }

    override fun before() {
        ViewModelPlugin.setActionFactoryPlugin(actionFactory)
    }

    override fun after() {
        ViewModelPlugin.setActionFactoryPlugin(DefaultLiveDataFactory())
    }
}