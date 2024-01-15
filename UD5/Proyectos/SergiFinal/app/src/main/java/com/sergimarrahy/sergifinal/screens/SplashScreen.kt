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
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import com.sergimarrahy.viewmodel.SeriesViewModel
import com.sergimarrahy.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current
    val seriesViewModel = remember {
        SeriesViewModel(context)
    }
    val splashViewModel = remember {
        SplashViewModel(context)
    }
    Splash()

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        seriesViewModel.getAllSeries()

        splashViewModel.isDataStored(
            onCollected = {
                if (it) {
                    navController.navigate(Routes.MainScreen.routes)
                } else {
                    navController.navigate(Routes.OnBoardingScreen.routes)
                }
            }
        )
    }
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
                    .size(height = 350.dp, width = 350.dp)
            )
        }
    }
}