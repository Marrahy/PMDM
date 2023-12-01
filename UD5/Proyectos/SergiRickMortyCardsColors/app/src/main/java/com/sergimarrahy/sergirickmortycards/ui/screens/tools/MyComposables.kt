package com.sergimarrahy.sergirickmortycards.ui.screens.tools

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CustomButton(text: String, navController: NavController, route: String) {
    Button(
        onClick = {
            navController.navigate(route = route)
        },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.inversePrimary)
    ) {
        Text(
            text = text
        )
    }
}