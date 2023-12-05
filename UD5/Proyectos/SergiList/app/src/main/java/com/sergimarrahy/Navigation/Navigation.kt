package com.sergimarrahy.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergimarrahy.Route.Routes
import com.sergimarrahy.screens.MainScreen
import com.sergimarrahy.screens.WowCharacterInfo
import com.sergimarrahy.sergilist.ViewModel.WowCharacterViewModel

@Composable
fun Navigation(wowCharacterViewModel: WowCharacterViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route,
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, wowCharacterViewModel)
        }

        composable(Routes.WowCharacterInfo.route) {
            WowCharacterInfo(navController, wowCharacterViewModel)
        }
    }
}