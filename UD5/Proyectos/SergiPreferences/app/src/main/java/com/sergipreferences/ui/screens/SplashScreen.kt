/**
 * @author Sergi Marrahy Arenas
 * @version 6.4
 */

package com.sergipreferences.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergipreferences.R
import com.sergipreferences.navigation.Routes
import com.sergipreferences.viewmodel.PreferencesViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        if (preferencesViewModel.isLoggedIn()) {
            preferencesViewModel.loadUserCredentials()
            navController.navigate(Routes.MainScreen.route)
        }
        navController.navigate(Routes.LoginScreen.route)
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile photo",
            modifier = Modifier
                .size(width = 200.dp, height = 200.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
        )
        Text(
            text = "Sergi Marrahy Arenas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
    }
}