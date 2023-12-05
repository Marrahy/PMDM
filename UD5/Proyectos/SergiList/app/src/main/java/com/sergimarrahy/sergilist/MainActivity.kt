package com.sergimarrahy.sergilist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sergimarrahy.Navigation.Navigation
import com.sergimarrahy.sergilist.ViewModel.WowCharacterViewModel
import com.sergimarrahy.sergilist.ui.theme.SergiListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val wowCharacterViewModel by viewModels<WowCharacterViewModel>()

        setContent {
            SergiListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(wowCharacterViewModel)
                }
            }
        }
    }
}
