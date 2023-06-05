package core.extension

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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

@Composable
fun ComponentActivity.onComposable(viewModel: ActionViewModel<*>) =
    viewModel.singleShotCompose().collectAsState().value

