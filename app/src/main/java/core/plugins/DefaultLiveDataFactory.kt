package core.plugins

import androidx.lifecycle.MutableLiveData
import core.action.UIAction

class DefaultLiveDataFactory : LiveDataFactory {

    override fun <T : UIAction> createMutableLiveData(): MutableLiveData<T> = MutableLiveData<T>()
}