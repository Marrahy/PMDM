/**
 * @author Sergi Marrahy Arenas
 * @version 6.4
 */

package com.sergipreferences.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergipreferences.R
import com.sergipreferences.navigation.Routes
import com.sergipreferences.viewmodel.PreferencesViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
) {
    var returnToLoginScreen by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (returnToLoginScreen) {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LaunchedEffect(key1 = returnToLoginScreen) {
                    delay(2000)
                }
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = stringResource(R.string.loading_text))
            }
        } else {
            Image(
                painter = painterResource(id = R.drawable.profile_photo),
                contentDescription = "Profile photo"
            )
            Text(text = "Sergi Marrahy Arenas")
            Text(text = "${stringResource(id = R.string.text_field_user_name)}: ${preferencesViewModel.userName.value}")
            Text(text = "${stringResource(id = R.string.text_field_phone_number)}: ${preferencesViewModel.phoneNumber.value}")
            Button(
                onClick = {
                    preferencesViewModel.deleteUserPreferences()
                    returnToLoginScreen = true
                    navController.navigate(Routes.LoginScreen.route)
                }
            ) {
                Text(text = stringResource(R.string.text_button_log_out))
            }
        }
    }
}