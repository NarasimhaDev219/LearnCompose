package com.example.learncompose.bottom_navigation

sealed class BottomScreens(val screen: String){

    data object Home: BottomScreens("home")
    data object Search: BottomScreens("search")
    data object Notification: BottomScreens("notification")
    data object Profile: BottomScreens("profile")
    data object Post: BottomScreens("post")

}