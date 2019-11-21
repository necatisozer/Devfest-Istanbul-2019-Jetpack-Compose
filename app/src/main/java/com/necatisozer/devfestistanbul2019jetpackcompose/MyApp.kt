package com.necatisozer.devfestistanbul2019jetpackcompose

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeColor
import com.necatisozer.devfestistanbul2019jetpackcompose.data.Speaker
import com.necatisozer.devfestistanbul2019jetpackcompose.data.materialDarkColors
import com.necatisozer.devfestistanbul2019jetpackcompose.data.materialLightColors
import com.necatisozer.devfestistanbul2019jetpackcompose.data.speakerList
import com.necatisozer.devfestistanbul2019jetpackcompose.ui.DetailScreen
import com.necatisozer.devfestistanbul2019jetpackcompose.ui.HomeScreen

@Composable
fun MyApp() {
    var currentTheme by +state { materialLightColors }
    var currentScreen by +state<Screen> { Screen.Home }
    var speakers by +state { speakerList }

    val changeTheme = {
        currentTheme =
            if (currentTheme == materialLightColors) materialDarkColors
            else materialLightColors
    }

    val changeSpeakerFavoriteStatus = { id: String ->
        speakers = speakers.map {
            if (it.id == id) it.copy(isFavorite = it.isFavorite.not())
            else it
        }
    }

    MaterialTheme(currentTheme) {
        Crossfade(currentScreen) { screen ->
            Surface(color = +themeColor { background }) {
                when (screen) {
                    is Screen.Home -> HomeScreen(
                        speakers = speakers,
                        changeSpeakerFavoriteStatus = changeSpeakerFavoriteStatus,
                        openDetail = { currentScreen = Screen.Detail(it) },
                        changeTheme = changeTheme
                    )
                    is Screen.Detail -> DetailScreen(
                        speaker = screen.speaker,
                        goBack = { currentScreen = Screen.Home },
                        changeTheme = changeTheme
                    )
                }
            }
        }
    }
}

private sealed class Screen {
    object Home : Screen()
    class Detail(val speaker: Speaker) : Screen()
}