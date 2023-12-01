/**
 * Applicación que muestra un tutorial un selector de pantallas, una pantalla para seleccionar a los personajes y una pantalla para comenzar la partida
 *
 * @author Sergi Marrahy Arenas
 * @version 5.4
 */

package com.sergimarrahy.sergirickmortycards.ui.screens.tutorialscreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.sergirickmortycards.R
import com.sergimarrahy.sergirickmortycards.navigation.Routes
import com.sergimarrahy.sergirickmortycards.ui.screens.tools.CustomButton

/**
 * Última pantalla que muestra un OutLinedTextField dónde puedes introducir tu nombre de usuario y saltar a la aplicación real
 *
 * @param navController Define la ruta de la pantalla a la que se quiere navegar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingLastScreen(navController: NavController) {
    var userName by rememberSaveable { mutableStateOf("") }
    var userNameIsValid by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                navController.popBackStack(Routes.OnBoardingRickMorty.route, false)
            }
        ) {
            Text(
                text = stringResource(R.string.reset_tutorial_text)
            )
        }
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        Column {
            OutlinedTextField(
                value = userName,
                onValueChange = {
                        input ->
                    userName = input
                    userNameIsValid = checkUserName(userName)
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.placeholder_input_text)
                    )
                },
                singleLine = true,
                isError = !userNameIsValid,
                supportingText = {
                    if (!userNameIsValid) {
                        Text(
                            text = stringResource(R.string.error_user_name_text),
                            color = Color.Red
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier
                .padding(10.dp)
            )
            AnimatedVisibility (userNameIsValid) {
                CustomButton(
                    text = stringResource(R.string.real_app_text),
                    navController = navController,
                    route = Routes.OnBoardingSelectScreen.route
                )
            }
        }
    }
}

/**
 * Valida el texto que introduce el usuario
 *
 * @param name Texto que introduce el usuario
 * @return true si es válido
 */
fun checkUserName(name: String): Boolean {
    val regex = Regex("^[a-zA-z]+$")
    return name.matches(regex)
}