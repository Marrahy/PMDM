/**
 * @author Sergi Marrahy Arenas
 * @version 6.4
 */

package com.sergipreferences.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergipreferences.navigation.Routes
import com.sergipreferences.viewmodel.PreferencesViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
) {
    val userName: String by preferencesViewModel.userName.observeAsState(initial = "")
    val phoneNumber by preferencesViewModel.phoneNumber.observeAsState(initial = "")
    val credentialsIsValid by derivedStateOf {
        credentialsAreValid(userName, phoneNumber)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp, top = 30.dp),
            text = "Nombre de usuario",
            color = Color.Gray,
            fontSize = 12.sp
        )
        TextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = userName,
            onValueChange = {
                userName ->
                preferencesViewModel.onUserNameChange(userName)
            },
            singleLine = true
        )
        Text(
            modifier = Modifier
                .padding(16.dp, top = 30.dp),
            text = "Número de teléfono",
            color = Color.Gray,
            fontSize = 12.sp
        )
        TextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = phoneNumber,
            onValueChange = {
                phoneNumber ->
                preferencesViewModel.onUserPhoneNumberChange(phoneNumber)
            },
            singleLine = true
        )
        Spacer(
            modifier = Modifier
                .padding(16.dp)
        )
        AnimatedVisibility(visible = credentialsIsValid) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 16.dp, end = 16.dp),
                onClick = {
                    preferencesViewModel.saveUserCredentials(userName, phoneNumber)
                    navController.navigate(Routes.MainScreen.route)
                }
            ) {
                Text(
                    text = "Siguiente",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

fun credentialsAreValid(userName: String, phoneNumber: String): Boolean {
    val validUserName = Regex("^[a-zA-Z]{3,}\$")
    val validPhoneNumber = Regex("^[0-9]{9}\$")

    return userName.matches(validUserName) && phoneNumber.matches(validPhoneNumber)
}
