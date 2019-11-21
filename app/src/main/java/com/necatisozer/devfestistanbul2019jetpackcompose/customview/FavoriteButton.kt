package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.themeColor
import com.necatisozer.devfestistanbul2019jetpackcompose.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onFavoriteChange: (Boolean) -> Unit
) {
    Ripple(bounded = false) {
        Toggleable(
            checked = isFavorite,
            onCheckedChange = onFavoriteChange
        ) {
            if (isFavorite) {
                SimpleVector(R.drawable.ic_baseline_favorite_24, +themeColor { error })
            } else {
                SimpleVector(R.drawable.ic_baseline_favorite_border_24, +themeColor { onSurface })
            }
        }
    }
}