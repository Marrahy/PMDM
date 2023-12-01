/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.sergirickmortycards.R
import com.sergimarrahy.sergirickmortycards.navigation.Routes
import com.sergimarrahy.sergirickmortycards.ui.screens.tools.CustomButton

/**
 * Segunda pantalla que muestra las cartas que puedes seleccionar
 *
 * @param navController Define la ruta de la pantalla a la que se quiere navegar
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingFight(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        AnimatedVisibility(visible = true, enter = expandIn()) {
            Text(
                text = stringResource(R.string.top_app_bar_do_your_chooses),
            )
        }
        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            item(){
                CardStructure(cardName = painterResource(id = R.drawable.card1), description = "card 1")
                CardStructure(cardName = painterResource(id = R.drawable.card2), description = "card 2")
                CardStructure(cardName = painterResource(id = R.drawable.card3), description = "card 3")

                Row {
                    CustomButton(
                        text = stringResource(R.string.button_text_jump),
                        navController,
                        Routes.OnBoardingLastScreen.route
                    )
                    Spacer(
                        modifier = Modifier
                        .padding(10.dp)
                    )
                    CustomButton(
                        text = stringResource(R.string.button_text_next_screen),
                        navController,
                        Routes.OnBoardingPeaceBetweenWorlds.route
                    )
                }
            }
        }
    }
}

/**
 * Estructura de un componente Image
 *
 * @param cardName ID de la imagen de la carta
 * @param description Nombre de la imagen
 */
@Composable
fun CardStructure(cardName: Painter, description: String) {
    Image(
        painter = cardName,
        contentDescription = description,
        modifier = Modifier.size(500.dp))
    Spacer(
        modifier = Modifier
            .padding(10.dp)
    )
}