/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
 * Tercera pantlla que muestra una imagen y un texto
 *
 * @param navController Define la ruta de la pantalla a la que se quiere navegar
 */
@Composable
fun OnBoardingPeaceBetweenWorlds(navController: NavController) {
    var visible by rememberSaveable { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(R.string.peace_between_worlds_text)
        )
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        AnimatedVisibility(
            visible = visible,
            enter = expandIn(),
            exit = shrinkOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.pazentremundos),
                contentDescription = "Imagen paz entre mundos"
            )
        }
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        Button(
            onClick = {
            visible = !visible
            }
        ) {
            Text(
                text = stringResource(R.string.button_text_show_image)
            )
        }
        CustomButton(
            text = stringResource(R.string.button_text_next_screen),
            navController = navController,
            route = Routes.OnBoardingLastScreen.route
        )
    }
}