package br.com.breno.blocknotescompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.ui.HomeContent
import br.com.breno.blocknotescompose.presentation.viewmodel.HomeViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.action.HomeViewAction
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val testViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionObserver()
        setComposeContents()
    }

    private fun setComposeContents() {
        setContent {
            BlockNotesComposeTheme {
                HomeContent(
                    onClickAction = testViewModel::navigateToInsertTest,
                    viewAction = testViewModel.state.collectAsState().value
                )
            }
        }
    }

    private fun getActionObserver() {
        onAction(testViewModel) { action ->
            when (action) {
                is HomeViewAction.NavigateToInsert -> navigateToInsert()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        testViewModel.getAllNotesTest()
    }

    private fun navigateToInsert() {
        AddNoteActivity.newIntent(this)
    }
}
