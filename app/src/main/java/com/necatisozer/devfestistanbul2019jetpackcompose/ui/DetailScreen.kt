package com.necatisozer.devfestistanbul2019jetpackcompose.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.TopAppBar
import androidx.ui.material.themeColor
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import com.necatisozer.devfestistanbul2019jetpackcompose.R
import com.necatisozer.devfestistanbul2019jetpackcompose.customview.PreviewTemplate
import com.necatisozer.devfestistanbul2019jetpackcompose.customview.PreviewTemplateDark
import com.necatisozer.devfestistanbul2019jetpackcompose.customview.SpeakerCard
import com.necatisozer.devfestistanbul2019jetpackcompose.customview.VectorImageButton
import com.necatisozer.devfestistanbul2019jetpackcompose.data.Speaker
import com.necatisozer.devfestistanbul2019jetpackcompose.data.speakerList

@Composable
fun DetailScreen(
    speaker: Speaker,
    goBack: () -> Unit,
    changeTheme: () -> Unit
) {
    FlexColumn {
        inflexible {
            DetailsAppBar(speaker.name, goBack, changeTheme)
        }
        flexible(1f) {
            Center {
                SpeakerCard(speaker)
            }
        }
    }
}

@Composable
private fun DetailsAppBar(
    title: String,
    goBack: () -> Unit,
    changeTheme: () -> Unit
) {
    TopAppBar(
        title = { Text(title, style = TextStyle(+themeColor { onSecondary })) },
        actionData = listOf(R.drawable.ic_round_highlight_24),
        color = +themeColor { secondary },
        navigationIcon = {
            VectorImageButton(
                id = R.drawable.ic_round_arrow_back_24,
                tint = +themeColor { onSecondary },
                onClick = goBack
            )
        }
    ) { item ->
        VectorImageButton(
            id = item,
            tint = +themeColor { onSecondary },
            onClick = changeTheme
        )
    }
}

@Preview("Detail Screen")
@Composable
private fun DetailScreenPreview() {
    PreviewTemplate {
        DetailScreen(speakerList.random(),
            {},
            {}
        )
    }
}

@Preview("Detail Screen Dark")
@Composable
private fun DetailScreenPreviewDark() {
    PreviewTemplateDark {
        DetailScreen(speakerList.random(),
            {},
            {}
        )
    }
}