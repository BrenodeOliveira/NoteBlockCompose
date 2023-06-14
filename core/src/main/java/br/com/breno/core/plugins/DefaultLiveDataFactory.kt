package br.com.breno.core.plugins

import androidx.lifecycle.MutableLiveData
import br.com.breno.core.action.UIAction

class DefaultLiveDataFactory : LiveDataFactory {

    override fun <T : UIAction> createMutableLiveData(): MutableLiveData<T> = MutableLiveData<T>()
}