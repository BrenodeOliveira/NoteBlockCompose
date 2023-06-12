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
    actionObserver: Observer<UIAction> = mockk()
) : ExternalResource() {
    private val factory = TestLiveDataFactory(actionObserver)

    fun <T : UIAction> getActionObserver(): Observer<T> {
        try {
            return factory.actionObserver as Observer<T>
        } catch (e: UninitializedPropertyAccessException) {
            throw Throwable("Not initialized")
        }
    }

    override fun before() {
        ViewModelPlugin.setFactoryPlugin(factory)
    }

    override fun after() {
        ViewModelPlugin.setFactoryPlugin(DefaultLiveDataFactory())
    }
}