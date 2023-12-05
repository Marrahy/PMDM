package com.sergimarrahy.Route

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object WowCharacterInfo: Routes("wow_character_info_screen")
}