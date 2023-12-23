/**
 * @author Sergi Marrahy Arenas
 * @version 6.4
 */

package com.sergipreferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.SergiPreferencesTheme
import com.sergipreferences.navigation.Navigation
import com.sergipreferences.viewmodel.PreferencesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferencesViewModel by viewModels<PreferencesViewModel>()

        setContent {
            AppContent {
                Navigation(preferencesViewModel)
            }
        }
    }
}

@Composable
fun AppContent(content: @Composable () -> Unit) {
    SergiPreferencesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}