package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.compose.Composable
import androidx.ui.core.Dp
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.Container

@Composable
fun ResizedImage(
    image: Image,
    tint: Color? = null,
    width: Dp,
    height: Dp
) {
    Container(width = width, height = height) {
        DrawImage(image, tint)
    }

}