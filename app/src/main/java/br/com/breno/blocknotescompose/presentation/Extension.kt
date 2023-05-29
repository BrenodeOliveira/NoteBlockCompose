package br.com.breno.blocknotescompose.presentation

import androidx.activity.ComponentActivity
import br.com.breno.blocknotescompose.presentation.viewmodel.TestViewModel
import core.action.UIAction

fun ComponentActivity.onAction(viewModel: TestViewModel, action: (UIAction) -> Unit) {
    viewModel.singleShot().observe(this) {
        action.invoke(it)
    }
}