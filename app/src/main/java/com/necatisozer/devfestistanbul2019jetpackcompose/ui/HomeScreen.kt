package com.necatisozer.devfestistanbul2019jetpackcompose.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.FlexColumn
import androidx.ui.material.ListItem
import androidx.ui.material.TopAppBar
import androidx.ui.material.themeColor
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import com.necatisozer.devfestistanbul2019jetpackcompose.R
import com.necatisozer.devfestistanbul2019jetpackcompose.customview.*
import com.necatisozer.devfestistanbul2019jetpackcompose.data.Speaker
import com.necatisozer.devfestistanbul2019jetpackcompose.data.speakerList

@Composable
fun HomeScreen(
    speakers: List<Speaker>,
    changeSpeakerFavoriteStatus: (String) -> Unit,
    openDetail: (Speaker) -> Unit,
    changeTheme: () -> Unit
) {
    FlexColumn {
        inflexible {
            HomeAppBar(changeTheme)
        }
        flexible(1f) {
            HomeBody(speakers, changeSpeakerFavoriteStatus, openDetail)
        }
    }
}

@Composable
private fun HomeAppBar(changeTheme: () -> Unit) {
    TopAppBar(
        title = {
            Text("Devfest Istanbul 2019", style = TextStyle(+themeColor { onPrimary }))
        },
        actionData = listOf(R.drawable.ic_round_highlight_24),
        navigationIcon = {
            ResizedImage(
                image = +imageResource(R.drawable.devfest),
                tint = +themeColor { onPrimary },
                width = 36.dp,
                height = 36.dp
            )
        }
    ) { item ->
        VectorImageButton(
            id = item,
            tint = +themeColor { onPrimary },
            onClick = changeTheme
        )
    }
}

@Composable
private fun HomeBody(
    speakers: List<Speaker>,
    changeSpeakerFavoriteStatus: (String) -> Unit,
    openDetail: (Speaker) -> Unit
) {
    VerticalScrollingList(speakers) { speaker ->
        ListItem(
            icon = { CircularImage(speaker.image, 48.dp) },
            text = { Text(speaker.name) },
            secondaryText = { Text(speaker.session) },
            trailing = {
                FavoriteButton(
                    isFavorite = speaker.isFavorite,
                    onFavoriteChange = { changeSpeakerFavoriteStatus(speaker.id) }
                )
            },
            onClick = { openDetail(speaker) }
        )
    }
}

@Preview("Home Screen")
@Composable
private fun HomeScreenPreview() {
    PreviewTemplate {
        HomeScreen(
            speakerList,
            {},
            {},
            {}
        )
    }
}

@Preview("Home Screen Dark")
@Composable
private fun HomeScreenPreviewDark() {
    PreviewTemplateDark {
        HomeScreen(
            speakerList,
            {},
            {},
            {}
        )
    }
}