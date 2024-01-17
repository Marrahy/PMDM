package com.sergimarrahy.sergifinal.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sergimarrahy.sergifinal.R
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.viewmodel.MainScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(Routes.MainScreen.routes)
        mainScreenViewModel.isDataStored(
            onCollected = {
                if (it) {
                    navController.navigate(Routes.MainScreen.routes)
                } else {
                    navController.navigate(Routes.OnBoardingScreen.routes)
                }
            }
        )
    }

    Splash()
}

@Composable
fun Splash() {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visibleState = state,
            enter = expandVertically(),
            exit = scaleOut()
        )  {
            Image(
                painter = painterResource(id = R.drawable.cn_logo),
                contentDescription = "Profile photo",
                modifier = Modifier
                    .size(height = 225.dp, width = 225.dp)
            )
        }
    }
}