package com.sergimarrahy.route

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object WorkoutScreen: Routes("workout_screen")
}