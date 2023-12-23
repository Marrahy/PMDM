package com.sergipreferences.navigation

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object LoginScreen : Routes("login_screen")
    object MainScreen : Routes("main_screen")
}