package com.sergimarrahy.sergiworkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.compose.SergiWorkoutTheme
import com.sergimarrahy.navigation.Navigation
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel
import com.sergimarrahy.sergiworkout.viewmodel.MainViewModel
import com.sergimarrahy.sergiworkout.viewmodel.WorkoutViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val commonViewModel by viewModels<CommonViewModel>()
        val mainViewModel by viewModels<MainViewModel>()
        val workoutViewModel by viewModels<WorkoutViewModel>()

        setContent {
            SergiWorkoutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(commonViewModel, mainViewModel, workoutViewModel)
                }
            }
        }
    }
}
