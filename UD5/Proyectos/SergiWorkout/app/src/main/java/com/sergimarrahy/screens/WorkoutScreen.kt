package com.sergimarrahy.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel

@Composable
fun WorkoutScreen(navController: NavController, commonViewModel: CommonViewModel) {

    Text(text = "${commonViewModel.repsNumber.value}")
}