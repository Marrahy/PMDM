package com.sergimarrahy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergimarrahy.route.Routes
import com.sergimarrahy.screens.MainScreen
import com.sergimarrahy.screens.WorkoutScreen
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel

@Composable
fun Navigation(commonViewModel: CommonViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, commonViewModel)
        }

        composable(Routes.WorkoutScreen.route) {
            WorkoutScreen(navController, commonViewModel)
        }
    }
}