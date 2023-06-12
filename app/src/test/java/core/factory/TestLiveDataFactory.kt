package core.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import core.action.UIAction
import core.plugins.LiveDataFactory

@Suppress("UNCHECKED_CAST")
class TestLiveDataFactory(val actionObserver: Observer<UIAction>): LiveDataFactory {

    override fun <T : UIAction> createMutableLiveData(): MutableLiveData<T> =
        MutableLiveData<T>().apply {
            observeForever(actionObserver as Observer<T>)
        }
}
