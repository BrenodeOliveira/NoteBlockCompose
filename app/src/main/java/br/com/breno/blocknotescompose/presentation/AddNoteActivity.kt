package br.com.breno.blocknotescompose.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.viewmodel.AddNoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteActivity: ComponentActivity() {

    private val viewModel: AddNoteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlockNotesComposeTheme {
                Column(Modifier.padding(32.dp)) {

                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context) {
            val intent = Intent(context, AddNoteActivity::class.java)
            context.startActivity(intent)
        }
    }
}