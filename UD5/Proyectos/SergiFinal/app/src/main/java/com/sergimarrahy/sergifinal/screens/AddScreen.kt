package com.sergimarrahy.sergifinal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.sergifinal.tools.TopCenterAppBarCustom
import com.sergimarrahy.viewmodel.AddScreenViewModel
import com.sergimarrahy.viewmodel.SeriesViewModel

@Composable
fun AddScreen(navController: NavHostController) {
    val context = LocalContext.current
    val seriesViewModel = remember {
        SeriesViewModel(context)
    }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopCenterAppBarCustom(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.AddScreen.routes)
                },
                containerColor = contentColorFor(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir serie"
                )
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            val addSeriesViewModel = remember {
                AddScreenViewModel()
            }
            val inputSeriesName by addSeriesViewModel.seriesName.observeAsState(initial = "")

            Spacer(modifier = Modifier.padding(innerPadding))
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(Color.White),
                value = inputSeriesName,
                onValueChange = {
                    addSeriesViewModel.onSeriesNameChange(it)
                },
                label = {
                    Text(
                        text = "Nombre de la serie"
                    )
                }
            )
            Button(
                onClick = {
                    seriesViewModel.addSeries(inputSeriesName, "description", 1)
                    addSeriesViewModel.onSeriesNameDelete()
                },
            ) {
                Text(
                    text = "Añadir"
                )
            }
        }
    }
}