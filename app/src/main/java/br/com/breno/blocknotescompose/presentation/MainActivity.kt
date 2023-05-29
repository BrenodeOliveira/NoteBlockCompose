package br.com.breno.blocknotescompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.ui.HomeContent
import br.com.breno.blocknotescompose.presentation.viewmodel.MainViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.TestViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.action.MainViewAction
import br.com.breno.blocknotescompose.presentation.viewmodel.action.TestViewAction
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private val testViewModel: TestViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getObservables()
        getActionObserver()
        setContent {
            BlockNotesComposeTheme {
                HomeContent(
                    onClickAction = testViewModel::teste,
                    viewAction = mainViewModel.state.collectAsState().value
                )
            }
        }
    }

    private fun getActionObserver() {
        onAction(testViewModel) { action ->
            when (action) {
                is TestViewAction.Test1 -> navigateToInsert()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getAllNotes()
    }

    private fun getObservables() {
        mainViewModel.actions.observe(this) { action ->
            when (action) {
                is MainViewAction.NavigateToInsert -> navigateToInsert()
                else -> Unit
            }
        }
    }

    private fun navigateToInsert() {
        AddNoteActivity.newIntent(this)
    }
}
