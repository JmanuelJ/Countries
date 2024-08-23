package com.juanma.exercise.countries.presentation.navigation

sealed class Screens(val route: String) {
    data object ScreenOne : Screens("screen_one")
    data object ScreenTwo : Screens("screen_two/{name}") {
        fun passName(name: String) = "screen_two/$name"
    }
}