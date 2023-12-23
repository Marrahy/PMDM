package com.sergipreferences.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sergipreferences.ui.screens.LoginScreen
import com.sergipreferences.ui.screens.MainScreen
import com.sergipreferences.ui.screens.SplashScreen
import com.sergipreferences.viewmodel.PreferencesViewModel

@Composable
fun Navigation(preferencesViewModel: PreferencesViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(
            route = Routes.SplashScreen.route,
        ) {
            SplashScreen(navController, preferencesViewModel)
        }
        composable(
            route = Routes.LoginScreen.route
        ) {
            LoginScreen(navController, preferencesViewModel)
        }

        composable(
            route = Routes.MainScreen.route
        ) {
            MainScreen(navController, preferencesViewModel)
        }
    }
}