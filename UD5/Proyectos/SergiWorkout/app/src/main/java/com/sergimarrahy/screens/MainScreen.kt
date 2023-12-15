package com.sergimarrahy.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.route.Routes
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    commonViewModel: CommonViewModel
) {
    var errorMessage by rememberSaveable { mutableStateOf("No puedes hacer menos de 3 repeticiones") }
    val context = LocalContext.current
    var userName by rememberSaveable { mutableStateOf("") }
    val userNameIsValid by remember {
        derivedStateOf {
            checkUserName(userName)
        }
    }
    val commonRepsNumber: Int by commonViewModel.repsNumber.observeAsState(initial = 3)

    Scaffold(
        bottomBar = {
            BottomAppBar {
                LaunchedEffect(key1 = errorMessage) {
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "¡Frase Motivadora!"
            )
            Row {
                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    modifier = Modifier
                        .size(width = 200.dp, height = 60.dp),
                    singleLine = true,
                    isError = !userNameIsValid,
                    supportingText = {
                        if (userName.isNotBlank() && !userNameIsValid) {
                            Text(
                                text = "Nombre de usuario no válido",
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Usuario"
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "User name"
                        )
                    }
                )
                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                )
                Column {
                    OutlinedTextField(
                        value = "$commonRepsNumber",
                        onValueChange = {

                        },
                        label = {
                            Text(
                                text = "Repeticiones"
                            )
                        },
                        readOnly = true,
                        modifier = Modifier
                            .size(width = 120.dp, height = 60.dp),
                    )
                    Row {
                        Button(
                            onClick = {
                                commonViewModel.sumRepsNumber()
                            }
                        ) {
                            Text(
                                text = "+1"
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Button(
                            onClick = {
                                if (commonRepsNumber != 3 ) commonViewModel.minusRepsNumber()
                            }
                        ) {
                            Text(
                                text = "-1"
                            )
                        }
                    }
                }
            }
            Button(
                enabled = userNameIsValid,
                onClick = {
                    navController.navigate(Routes.WorkoutScreen.route)
                }
            ) {
                Text(
                    text = "Siguiente"
                )
            }
        }
    }
}

fun checkUserName(name: String): Boolean {
    val regex = Regex("^[a-zA-z]+$")
    return name.matches(regex)
}
