package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Dp
import androidx.ui.core.WithDensity
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Container
import androidx.ui.res.imageResource
import kotlin.math.min

@Composable
fun CircularImage(@DrawableRes id: Int, size: Dp? = null) {
    val image = +imageResource(id)
    WithDensity {
        val newSize = size ?: min(image.width, image.height).toDp()
        Container(width = newSize, height = newSize) {
            Clip(shape = RoundedCornerShape(newSize / 2)) {
                DrawImage(image)
            }
        }
    }
}