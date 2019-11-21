package com.necatisozer.devfestistanbul2019jetpackcompose.customview

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.surface.Card
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import com.necatisozer.devfestistanbul2019jetpackcompose.data.Speaker
import com.necatisozer.devfestistanbul2019jetpackcompose.data.speakerList

@Composable
fun SpeakerCard(speaker: Speaker) {
    Card(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {
        Container(width = 240.dp, height = 340.dp) {
            Column(
                mainAxisSize = LayoutSize.Expand,
                crossAxisSize = LayoutSize.Expand
            ) {
                Container(expanded = true, height = 240.dp) {
                    DrawImage(+imageResource(speaker.image))
                }
                Column(Spacing(16.dp)) {
                    Row(mainAxisSize = LayoutSize.Expand) {
                        Text(
                            text = speaker.name,
                            style = (+themeTextStyle { h6 }).withOpacity(0.87f)
                        )
                        Column(
                            modifier = Flexible(1f),
                            crossAxisAlignment = CrossAxisAlignment.End
                        ) {
                            FavoriteIcon(speaker.isFavorite)
                        }
                    }
                    Text(
                        text = speaker.session,
                        style = (+themeTextStyle { body2 }).withOpacity(
                            0.87f
                        )
                    )
                }
            }
        }
    }
}

@Preview("Speaker Card")
@Composable
private fun SpeakerCardPreview() {
    PreviewTemplate {
        SpeakerCard(speakerList.random())
    }
}

@Preview("Speaker Card - Dark")
@Composable
private fun SpeakerCardPreviewDark() {
    PreviewTemplateDark {
        SpeakerCard(speakerList.random())
    }
}