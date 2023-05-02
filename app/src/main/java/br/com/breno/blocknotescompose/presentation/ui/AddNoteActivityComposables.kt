package br.com.breno.blocknotescompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldNote(
    modifier: Modifier,
    label: String,
    placeholder: String,
    newText: MutableState<String>
) {
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            value = newValue
            newText.value = newValue
        },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = modifier,
    )
}

@Composable
fun ButtonAddNote(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(text = "Adicionar anotação")
    }
}

@Composable
fun AddNoteContent(newTitle: MutableState<String>, newSubtitle: MutableState<String>, onClick: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Inserir nota") })
    }) {
        it
        Column(
            Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            TextFieldNote(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                label = "Título",
                placeholder = "Digite aqui o título",
                newText = newTitle
            )
            TextFieldNote(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                label = "Descrição",
                placeholder = "Digite aqui a descrição",
                newText = newSubtitle
            )

            ButtonAddNote(onClick = onClick)
        }
    }
}