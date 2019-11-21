package com.necatisozer.devfestistanbul2019jetpackcompose.example

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.res.imageResource

@Composable
fun FilteredList(contacts: List<Contact>, filterText: String = "") {
    val state = +state { filterText }
    VerticalScroller {
        Column {
            TextField(filterText, onValueChange = { state.value = it })
            contacts.filter { it.name.contains(state.value) }.forEach {
                Row {
                    SimpleImage(+imageResource(it.photo))
                    Text(it.name)
                }
            }
        }
    }
}