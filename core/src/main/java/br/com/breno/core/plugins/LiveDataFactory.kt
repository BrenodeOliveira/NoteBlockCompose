package br.com.breno.core.plugins

import androidx.lifecycle.MutableLiveData
import br.com.breno.core.action.UIAction

interface LiveDataFactory {

    fun <T : UIAction> createMutableLiveData(): MutableLiveData<T>
}