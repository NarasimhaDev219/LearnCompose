package com.example.learncompose.navigation_drawer

sealed class Screens(val screen: String){

    data object Home: Screens("Home")
    data object Profile: Screens("Profile")
    data object Settings: Screens("Settings")
}