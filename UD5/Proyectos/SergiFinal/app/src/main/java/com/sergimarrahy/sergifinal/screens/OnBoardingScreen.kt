package com.sergimarrahy.sergifinal.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sergimarrahy.sergifinal.R
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
    val credentialsAreValid by derivedStateOf {
        userNameIsValid(userName)
    }
    var isRegistered by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.cn_logo),
            contentDescription = "Logo"
        )
        AnimatedVisibility(visible = true) {
            if (!isRegistered) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "¡Bienvenido a la aplicación dónde podrás guardar todas tus series favoritas!",
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = {
                            isRegistered = !isRegistered
                        },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
                    ) {
                        Text(text = "Registrarse")
                    }
                }
            }
        }

        if (isRegistered) {
            AnimatedVisibility(
                visible = isRegistered,
                enter = expandHorizontally()
            ) {
                TextField (
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = userName,
                    onValueChange = { commonViewModel.onUserNameChange(it) },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Nombre de usuario"
                        )
                    },
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onTertiaryContainer),
                    leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Icono del campo") }
                )
            }
        }
        Spacer(
            modifier = Modifier
                .padding(16.dp)
        )
        AnimatedVisibility(visible = credentialsAreValid, enter = expandHorizontally()) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 16.dp, end = 16.dp),
                onClick = {
                    commonViewModel.saveUserName(userName)
                    navController.popBackStack()
                    navController.navigate(Routes.MainScreen.routes)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
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

fun userNameIsValid(userName: String): Boolean {
    val validUserName = Regex("^[a-zA-Z]{3,}\$")

    return userName.matches(validUserName)
}
