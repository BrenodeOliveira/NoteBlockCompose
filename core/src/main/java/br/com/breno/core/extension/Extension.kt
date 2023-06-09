package br.com.breno.core.extension

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import br.com.breno.core.action.UIAction
import br.com.breno.core.viewmodel.ActionViewModel

fun ComponentActivity.onAction(
    viewModel: ActionViewModel<*>,
    action: (UIAction) -> Unit
) {
    viewModel.singleShot().observe(this) {
        action(it)
    }
}

@Composable
fun ComponentActivity.onComposable(viewModel: ActionViewModel<*>) =
    viewModel.singleShotCompose().value

