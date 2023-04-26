package br.com.breno.blocknotescompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.breno.blocknotescompose.data.model.NoteModel

@Composable
fun CardBlock(noteModel: NoteModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = noteModel.title,
                modifier = Modifier.padding(16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = noteModel.subtitle,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
fun LazyList(notes: List<NoteModel>) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notes) {
            CardBlock(noteModel = it)
        }
    }
}

@Composable
fun HomeContent(onClickAction: () -> Unit, notes: List<NoteModel>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Bloco de notas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onClickAction,
                backgroundColor = Color.Green,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                    )
                }
            )
        },
        content = {
            it
            Surface {
                LazyList(notes = notes)
            }
        }
    )
}