package com.necatisozer.devfestistanbul2019jetpackcompose.data

import androidx.annotation.DrawableRes
import com.necatisozer.devfestistanbul2019jetpackcompose.R

data class Speaker(
    val id: String,
    @DrawableRes val image: Int,
    val name: String,
    val session: String,
    val isFavorite: Boolean = false
)

val speakerList = listOf(
    Speaker("0", R.drawable.cafer_mert_ceyhan,"Cafer Mert Ceyhan", "Manage UI Navigation with Jetpack Navigation Component"),
    Speaker("1", R.drawable.erol_kaftanoglu,"Erol Kaftanoğlu", "Exploring Firebase Predictions"),
    Speaker("2", R.drawable.hadi_tok,"Hadi Tok", "Finding the view"),
    Speaker("3", R.drawable.murat_can_bur,"Murat Can Bur", "Unit Testing For Android Developers"),
    Speaker("4", R.drawable.murat_yener,"Murat Yener", "What is new with Android 10 UI"),
    Speaker("5", R.drawable.necati_sozer,"Necati Sözer", "Declarative UI Paradigm feat. Jetpack Compose"),
    Speaker("6", R.drawable.nilay_yener,"Nilay Yener", "Flutter! Nedir, Nasil, Neden?"),
    Speaker("7", R.drawable.okan_aydin,"Okan Aydın", "Manage UI Navigation with Jetpack Navigation Component"),
    Speaker("8", R.drawable.resul_caner_yildirim,"Resul Caner Yıldırım", "Designing for Interactive Canvas on Google Assistant"),
    Speaker("9", R.drawable.selin_alara_ornek,"Selin Alara Örnek", "Robotlarım ve Google")
)
