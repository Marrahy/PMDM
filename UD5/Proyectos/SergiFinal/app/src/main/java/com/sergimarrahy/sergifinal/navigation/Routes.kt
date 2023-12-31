package com.sergimarrahy.sergifinal.navigation

sealed class Routes(val routes: String) {
    object SplashScreen : Routes("splash_screen")
    object MainScreen : Routes("main_screen")
    object OnBoardingScreen : Routes("onboarding_screen")
    object AuthorScreen : Routes("author_screen")
    object ObjectScreen : Routes("object_screen")
    object AddScreen : Routes("add_screen")
    object EditScreen : Routes("edit_screen")
}