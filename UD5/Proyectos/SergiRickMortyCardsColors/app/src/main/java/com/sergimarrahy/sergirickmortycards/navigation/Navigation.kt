/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens.OnBoardingRickMorty
import com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens.OnBoardingFight
import com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens.OnBoardingPeaceBetweenWorlds
import com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens.OnBoardingLastScreen
import com.sergimarrahy.sergirickmortycards.ui.screens.profilescreen.SplashScreen
import com.sergimarrahy.sergirickmortycards.ui.screens.realapplication.MainScreen
import com.sergimarrahy.sergirickmortycards.ui.screens.realapplication.SelectScreen
import com.sergimarrahy.sergirickmortycards.ui.screens.realapplication.TeamScreen

/**
 * Función para deifinir las rutas de las pantallas
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(
            route = Routes.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Routes.OnBoardingRickMorty.route
        ) {
            OnBoardingRickMorty(navController)
        }
        composable(
            route = Routes.OnBoardingFight.route
        ) {
            OnBoardingFight(navController)
        }
        composable(
            route = Routes.OnBoardingPeaceBetweenWorlds.route
        ) {
            OnBoardingPeaceBetweenWorlds(navController)
        }
        composable(
            route = Routes.OnBoardingLastScreen.route
        ) {
            OnBoardingLastScreen(navController)
        }
        composable (
            route = Routes.OnBoardingSelectScreen.route
        ) {
            SelectScreen(navController)
        }
        composable(
            route = Routes.OnBoardingMainScreen.route
        ) {
            MainScreen(navController)
        }
        composable(
            route = Routes.OnBoardingTeamScreen.route
        ) {
            TeamScreen(navController)
        }
    }
}

