/**
 * @author Sergi Marrahy Arenas
 * @version 6.4
 */

package com.sergipreferences.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.sergipreferences.R
import com.sergipreferences.navigation.Routes
import com.sergipreferences.viewmodel.PreferencesViewModel

@Composable
fun MainScreen(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = "Profile photo"
        )
        Text(text = "Sergi Marrahy Arenas")
        Text(text = "Nombre de usuario: ${preferencesViewModel.userName.value!!}")
        Text(text = "Número de teléfono del usuario: ${preferencesViewModel.phoneNumber.value!!}")
        Button(
            onClick = {
                //preferencesViewModel.deleteAllData("", "")
                navController.navigate(Routes.LoginScreen.route)
            }
        ) {
            Text(text = "Cerrar sesión")
        }
    }
}