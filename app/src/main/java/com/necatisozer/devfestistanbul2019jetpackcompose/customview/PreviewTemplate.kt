package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeColor
import com.necatisozer.devfestistanbul2019jetpackcompose.data.materialDarkColors
import com.necatisozer.devfestistanbul2019jetpackcompose.data.materialLightColors

@Composable
fun PreviewTemplate(
    materialColors: MaterialColors = materialLightColors,
    children: @Composable() () -> Unit
) {
    MaterialTheme(materialColors) {
        Surface(
            color = +themeColor { background },
            children = children
        )
    }
}

@Composable
fun PreviewTemplateDark(children: @Composable() () -> Unit) {
    PreviewTemplate(materialDarkColors, children)
}