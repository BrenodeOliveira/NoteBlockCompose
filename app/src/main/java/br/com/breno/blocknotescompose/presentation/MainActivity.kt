package br.com.breno.blocknotescompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.ui.HomeContent
import br.com.breno.blocknotescompose.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.getAllNotes()

        getObservables()

        setContent {
            BlockNotesComposeTheme {
                HomeContent(
                    onClickAction = mainViewModel::navigateToInsert,
                    mainViewModel.listNote.value
                )
            }
        }
    }

    private fun getObservables() {
        mainViewModel.navigate.observe(this) {
            if (it) AddNoteActivity.newIntent(this)
        }
    }
}
