package com.sergimarrahy.sergifinal.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.sergifinal.tools.TopCenterAppBarCustom
import com.sergimarrahy.viewmodel.MainScreenViewModel

@Composable
fun AddScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopCenterAppBarCustom(navController, mainScreenViewModel)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.popBackStack()
                },
                containerColor = contentColorFor(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver atrás",
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            val addingOption by rememberSaveable { mutableStateOf(false) }
            var inputSeriesName by rememberSaveable { mutableStateOf("") }
            var inputDescription by rememberSaveable { mutableStateOf("") }
            var inputChapterNumber by rememberSaveable { mutableStateOf("") }

            Spacer(modifier = Modifier.padding(innerPadding))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                value = inputSeriesName,
                onValueChange = { input ->
                    inputSeriesName = input
                },
                label = {
                    Text(
                        text = "Nombre de la serie"
                    )
                }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                value = inputDescription,
                onValueChange = { input ->
                    inputDescription = input
                },
                label = {
                    Text(
                        text = "Descripción de la serie"
                    )
                }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                value = inputChapterNumber,
                onValueChange = { input ->
                    inputChapterNumber = input
                },
                label = {
                    Text(
                        text = "Número de capítulos"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.padding(24.dp))
            Button(
                onClick = {
                    mainScreenViewModel.addSeries(inputSeriesName, inputDescription, inputChapterNumber)
                    inputSeriesName = ""
                    inputDescription = ""
                    inputChapterNumber = ""
                }
            ) {
                AnimatedVisibility(visible = true) {
                    if (addingOption) {
                        Text(
                            modifier = Modifier.size(width = 100.dp, height = 20.dp),
                            text = "Añadir",
                            textAlign = TextAlign.Center
                        )
                    } else {
                        Text(
                            modifier = Modifier.size(width = 100.dp, height = 20.dp),
                            text = "Editar",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
