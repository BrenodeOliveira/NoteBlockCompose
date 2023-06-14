package br.testing_base.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.breno.core.action.UIAction
import br.com.breno.core.plugins.LiveDataFactory

@Suppress("UNCHECKED_CAST")
class TestLiveDataFactory(
    val actionObserver: Observer<UIAction>,
    val composeObserver: Observer<UIAction>
) : LiveDataFactory {

    override fun <T : UIAction> createMutableLiveData(): MutableLiveData<T> =
        MutableLiveData<T>().apply {
            observeForever(actionObserver as Observer<T>)
            observeForever(composeObserver as Observer<T>)
        }
}
