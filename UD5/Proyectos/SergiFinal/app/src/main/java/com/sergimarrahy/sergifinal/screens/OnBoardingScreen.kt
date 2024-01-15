package com.sergimarrahy.sergifinal.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.viewmodel.CommonViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val context = LocalContext.current
    val commonViewModel = remember {
        CommonViewModel(context)
    }
    val userName by commonViewModel.userName.observeAsState(initial = "")
    val phoneNumber by commonViewModel.phoneNumber.observeAsState(initial = "")
    val email by commonViewModel.email.observeAsState(initial = "")
    val credentialsAreValid by derivedStateOf {
        credentialsAreValid(userName, phoneNumber, email)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = userName,
            onValueChange = { commonViewModel.onUserNameChange(userName) },
            singleLine = true,
            label = {
                Text(
                    text = "Nombre de usuario"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(MaterialTheme.colorScheme.onTertiaryContainer)
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = phoneNumber,
            onValueChange = { commonViewModel.onUserPhoneNumberChange(phoneNumber) },
            singleLine = true,
            label = {
                Text(
                    text = "Número de teléfono"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(MaterialTheme.colorScheme.onTertiaryContainer)
        )
        OutlinedTextField (
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = { commonViewModel.onUserEmailChange(email) },
            singleLine = true,
            label = {
                Text(
                    text = "Correo"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(MaterialTheme.colorScheme.onTertiaryContainer)
        )
        Spacer(
            modifier = Modifier
                .padding(16.dp)
        )
        AnimatedVisibility(visible = credentialsAreValid) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 16.dp, end = 16.dp),
                onClick = {
                    commonViewModel.saveUserCredentials(userName, phoneNumber, email)
                    navController.navigate(Routes.MainScreen.routes)
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

fun credentialsAreValid(userName: String, phoneNumber: String, email: String): Boolean {
    val validUserName = Regex("^[a-zA-Z]{3,}\$")
    val validPhoneNumber = Regex("^[0-9]{9}\$")
    val validEmail = Regex("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")


    return userName.matches(validUserName) && phoneNumber.matches(validPhoneNumber) && email.matches(validEmail)
}