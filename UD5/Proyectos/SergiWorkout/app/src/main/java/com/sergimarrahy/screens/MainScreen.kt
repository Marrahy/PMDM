package com.sergimarrahy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.route.Routes
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    commonViewModel: CommonViewModel
) {
    var userName by rememberSaveable { mutableStateOf("") }
    val userNameIsValid by remember {
        derivedStateOf {
            checkUserName(userName)
        }
    }
    var repsNumber by rememberSaveable { mutableStateOf(3) }
    val commonRepsNumber: Int by commonViewModel.repsNumber.observeAsState(initial = repsNumber)

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
                            color = Color.Red
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
                    value = "$repsNumber",
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
                            repsNumber++
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
                            if (repsNumber != 3) repsNumber--
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

fun checkUserName(name: String): Boolean {
    val regex = Regex("^[a-zA-z]+$")
    return name.matches(regex)
}
