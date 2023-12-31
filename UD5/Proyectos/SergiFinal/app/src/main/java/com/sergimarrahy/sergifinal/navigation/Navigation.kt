package com.sergimarrahy.sergifinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sergimarrahy.sergifinal.screens.AddScreen
import com.sergimarrahy.sergifinal.screens.AuthorScreen
import com.sergimarrahy.sergifinal.screens.EditScreen
import com.sergimarrahy.sergifinal.screens.MainScreen
import com.sergimarrahy.sergifinal.screens.ObjectScreen
import com.sergimarrahy.sergifinal.screens.OnBoardingScreen
import com.sergimarrahy.sergifinal.screens.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.routes
    ) {
        composable(
            route = Routes.SplashScreen.routes,
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Routes.MainScreen.routes,
        ) {
            MainScreen(navController)
        }
        composable(
            route = Routes.OnBoardingScreen.routes,
        ) {
            OnBoardingScreen(navController)
        }
        composable(
            route = Routes.AuthorScreen.routes,
        ) {
            AuthorScreen(navController)
        }
        composable(
            route = Routes.AddScreen.routes,
        ) {
            AddScreen(navController)
        }
        composable(
            route = Routes.EditScreen.routes,
        ) {
            EditScreen(navController)
        }
        composable(
            route = Routes.ObjectScreen.routes
        ) {
            ObjectScreen(navController)
        }
    }
}