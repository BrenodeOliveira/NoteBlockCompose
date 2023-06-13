package core.rules

import androidx.lifecycle.Observer
import core.factory.TestLiveDataFactory
import core.action.UIAction
import core.factory.TestMutableStateFactory
import core.plugins.DefaultLiveDataFactory
import core.plugins.DefaultMutableStateFactory
import core.plugins.ViewModelPlugin
import io.mockk.mockk
import org.junit.rules.ExternalResource

@Suppress("UNCHECKED_CAST")
class ViewModelTestRule(
    actionObserver: Observer<UIAction> = mockk(),
    composeObserver: Observer<UIAction> = mockk(),
) : ExternalResource() {
    private val actionFactory = TestLiveDataFactory(actionObserver)
    private val composeFactory = TestMutableStateFactory(composeObserver)

    fun <T : UIAction> getActionObserver(): Observer<T> {
        try {
            return actionFactory.actionObserver as Observer<T>
        } catch (e: UninitializedPropertyAccessException) {
            throw Throwable("Not initialized")
        }
    }

    fun <T: UIAction> getComposeObserver(): Observer<T> {
        try {
            return composeFactory.actionObserver as Observer<T>
        } catch (e: UninitializedPropertyAccessException) {
            throw Throwable("Not initialized")
        }
    }

    override fun before() {
        ViewModelPlugin.setActionFactoryPlugin(actionFactory)
        ViewModelPlugin.setComposeFactoryPlugin(composeFactory)
    }

    override fun after() {
        ViewModelPlugin.setActionFactoryPlugin(DefaultLiveDataFactory())
        ViewModelPlugin.setComposeFactoryPlugin(DefaultMutableStateFactory())
    }
}