/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.sergirickmortycards.R
import com.sergimarrahy.sergirickmortycards.navigation.Routes
import com.sergimarrahy.sergirickmortycards.ui.screens.tools.CustomButton

/**
 * Primera pantalla que mostrará el logo de Rick y Morty y debajo del logo la foto del portal con los personajes.
 * En la parte inferior aparecerá un botón que pone saltar que irá a la 4ª pantalla del Onboarding y un
 * botón que pasará a la siguiente pantalla del OnBoarding
 *
 * @param navController Define la ruta de la pantalla a la que se quiere navegar
 */
@Composable
fun OnBoardingRickMorty(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.rymlogo),
            contentDescription = "logo"
        )
        Image(
            painter = painterResource(id = R.drawable.rymportal),
            contentDescription = "portal"
        )
        Row {
            CustomButton(
                text = stringResource(R.string.button_text_jump),
                navController = navController,
                route = Routes.OnBoardingLastScreen.route)
            Spacer(
                modifier = Modifier
                    .padding(16.dp)
            )
            CustomButton(
                text = stringResource(R.string.button_text_next_screen),
                navController,
                Routes.OnBoardingFight.route)
        }
    }
}
