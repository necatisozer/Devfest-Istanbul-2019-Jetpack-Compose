package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Opacity
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.Divider

@Composable
fun <T> VerticalScrollingList(
    list: List<T>,
    modifier: Modifier = Modifier.None,
    mainAxisAlignment: MainAxisAlignment = MainAxisAlignment.Start,
    mainAxisSize: LayoutSize = LayoutSize.Wrap,
    crossAxisAlignment: CrossAxisAlignment = CrossAxisAlignment.Start,
    crossAxisSize: LayoutSize = LayoutSize.Wrap,
    block: @Composable() (T) -> Unit
) {
    VerticalScroller {
        Column(
            modifier = modifier,
            mainAxisAlignment = mainAxisAlignment,
            mainAxisSize = mainAxisSize,
            crossAxisAlignment = crossAxisAlignment,
            crossAxisSize = crossAxisSize
        ) {
            list.forEach {
                block(it)
                Opacity(0.08f) {
                    Divider(Spacing(8.dp))
                }
            }
        }
    }
}