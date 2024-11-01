package com.example.learncompose.navigation_component

sealed class Destinations(val route : String) {

    data object MainScreen: Destinations("MainScreen")
    data object HomePage: Destinations("HomePage")
}