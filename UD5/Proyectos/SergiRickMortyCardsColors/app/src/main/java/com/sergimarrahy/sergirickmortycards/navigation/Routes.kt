/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.navigation

/**
 * Clase que no se puede heredar para instanciar las rutas
 */
sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object OnBoardingRickMorty : Routes("onboarding_rick_morty")
    object OnBoardingFight : Routes("onboarding_fight")
    object OnBoardingPeaceBetweenWorlds : Routes("onboarding_peace_between_worlds")
    object OnBoardingLastScreen : Routes("onboarding_last_screen")
    object OnBoardingSelectScreen : Routes ("onboarding_select_screen")
    object OnBoardingMainScreen : Routes("onboarding_main_screen")
    object OnBoardingTeamScreen : Routes("onboarding_team_screen")
}