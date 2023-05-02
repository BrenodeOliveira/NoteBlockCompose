package br.com.breno.blocknotescompose.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import br.com.breno.blocknotescompose.presentation.theme.BlockNotesComposeTheme
import br.com.breno.blocknotescompose.presentation.ui.AddNoteContent
import br.com.breno.blocknotescompose.presentation.viewmodel.AddNoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteActivity : ComponentActivity() {

    private val viewModel: AddNoteViewModel by viewModel()
    private var title: MutableState<String> = mutableStateOf("")
    private var subtitle: MutableState<String> = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlockNotesComposeTheme {
                AddNoteContent(newTitle = title, newSubtitle = subtitle) {
                    viewModel.insertNote(title = title.value, subtitle = subtitle.value)
                    finish()
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