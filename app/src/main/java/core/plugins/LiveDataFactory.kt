package core.plugins

import androidx.lifecycle.MutableLiveData
import core.action.UIAction

interface LiveDataFactory {

    fun <T : UIAction> createMutableLiveData(): MutableLiveData<T>
}