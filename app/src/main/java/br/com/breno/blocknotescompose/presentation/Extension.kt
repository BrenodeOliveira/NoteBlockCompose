package br.com.breno.blocknotescompose.presentation

import androidx.activity.ComponentActivity
import core.action.UIAction
import core.viewmodel.ActionViewModel

fun ComponentActivity.onAction(
    viewModel: ActionViewModel<*>,
    action: (UIAction) -> Unit
) {
    viewModel.singleShot().observe(this) {
        action(it)
    }
}

