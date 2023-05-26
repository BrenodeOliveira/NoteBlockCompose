package core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import core.action.UIAction

open class ActionViewModel<uiAction: UIAction>: ViewModel() {
    private val _singleShotEvent: MutableLiveData<UIAction> = MutableLiveData()

    fun singleShot() : LiveData<UIAction> = _singleShotEvent

    fun sendAction(uiAction: UIAction) {
        this._singleShotEvent.value = uiAction
    }
}