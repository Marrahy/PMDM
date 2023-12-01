/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.ui.screens.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergimarrahy.sergirickmortycards.R
import com.sergimarrahy.sergirickmortycards.navigation.Routes
import kotlinx.coroutines.delay


/**
 * Pantalla que muestra una foto y un texto que dura 3 segundos
 *
 * @param navController Define la ruta de la pantalla a la que se quiere navegar
 */
@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Routes.OnBoardingRickMorty.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilephoto),
                contentDescription = "profile photo"
            )
            Spacer(
                modifier = Modifier
                    .padding(top = 50.dp),
            )
            Text(
                text = "Sergi Marrahy Arenas",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}