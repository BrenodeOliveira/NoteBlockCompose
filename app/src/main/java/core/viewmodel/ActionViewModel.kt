package core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import core.action.ComposableAction
import core.action.UIAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class ActionViewModel<uiAction : UIAction> : ViewModel() {
    //Action with LiveData
    private val _singleShotEvent: MutableLiveData<UIAction> = MutableLiveData()

    fun singleShot(): LiveData<UIAction> = _singleShotEvent

    fun sendAction(uiAction: UIAction) {
        _singleShotEvent.value = uiAction
    }

    //Composables single shot
    private val _mutableState = MutableStateFlow<UIAction>(ComposableAction.InitializingCompose)

    fun singleShotCompose(): StateFlow<UIAction> = _mutableState.asStateFlow()

    fun sendComposable(uiAction: UIAction) {
        _mutableState.value = uiAction
    }
}