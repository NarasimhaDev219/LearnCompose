package com.example.learncompose.nav_bottomsheet

sealed class NavBottomScreens(val screen: String) {

    data object Home: NavBottomScreens("home")
    data object Search: NavBottomScreens("search")
    data object Notification: NavBottomScreens("notification")
    data object Profile: NavBottomScreens("profile")
    data object Post: NavBottomScreens("post")
    data object Settings: NavBottomScreens("settings")
}