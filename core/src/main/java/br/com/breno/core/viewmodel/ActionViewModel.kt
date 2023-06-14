package br.com.breno.core.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.breno.core.action.ComposableAction
import br.com.breno.core.action.UIAction
import br.com.breno.core.plugins.ViewModelPlugin

open class ActionViewModel<uiAction : UIAction> : ViewModel() {
    //Action with LiveData
    private val _singleShotEvent: MutableLiveData<UIAction> =
        ViewModelPlugin.actionFactory.createMutableLiveData()

    fun singleShot(): LiveData<UIAction> = _singleShotEvent

    fun sendAction(uiAction: UIAction) {
        _singleShotEvent.value = uiAction
    }

    //Composables single shot
    private val _mutableState: MutableLiveData<UIAction> =
        ViewModelPlugin.actionFactory.createMutableLiveData()

    @Composable
    fun singleShotCompose(): State<UIAction> =
        _mutableState.observeAsState(initial = ComposableAction.InitializingCompose)

    fun sendComposable(uiAction: UIAction) {
        _mutableState.value = uiAction
    }
}