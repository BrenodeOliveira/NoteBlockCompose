package br.com.breno.blocknotescompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.ui.HomeContent
import br.com.breno.blocknotescompose.presentation.viewmodel.HomeViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.action.HomeViewAction
import core.extension.onAction
import core.extension.onComposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionObserver()
        setContent {
            BlockNotesComposeTheme {
                HomeContent(
                    onClickAction = homeViewModel::navigateToInsert,
                    viewAction = onComposable(homeViewModel)
                )
            }
        }
    }

    private fun getActionObserver() {
        onAction(homeViewModel) { action ->
            when (action) {
                is HomeViewAction.NavigateToInsert -> navigateToInsert()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getAllNotes()
    }

    private fun navigateToInsert() {
        AddNoteActivity.newIntent(this)
    }
}
