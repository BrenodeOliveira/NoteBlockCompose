package br.com.breno.blocknotescompose.presentation

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import core.action.UIAction
import core.viewmodel.ActionViewModel
import kotlinx.coroutines.launch

fun ComponentActivity.onAction(viewModel: ActionViewModel<UIAction>) {
    lifecycleScope.launch {
        viewModel.singleShot().observe(this@onAction) {
            it
        }
    }
}