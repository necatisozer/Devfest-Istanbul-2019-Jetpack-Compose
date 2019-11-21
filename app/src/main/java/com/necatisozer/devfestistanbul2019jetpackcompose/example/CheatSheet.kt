package com.necatisozer.devfestistanbul2019jetpackcompose.example

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.Row

@Composable
private fun main() {
    Column {
        Text("Hello World!")

        val n = 10
        for (i in 1..n) {
            Row {
                for (j in 1..i) {
                    Text("*")
                }
            }
        }
    }
}