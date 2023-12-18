package com.sergimarrahy.screens

import android.annotation.SuppressLint
import android.os.Build.VERSION.SDK_INT
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.sergimarrahy.sergiworkout.viewmodel.CommonViewModel
import com.sergimarrahy.sergiworkout.viewmodel.WorkoutViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
    workoutViewModel: WorkoutViewModel
    ) {
    val seconds by rememberSaveable { mutableLongStateOf(commonViewModel.repsNumber.value!!.times(2).toLong()) }
    val listOfGifs by rememberSaveable { mutableStateOf(workoutViewModel.exercise.value!!) }
    var onClickButton by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "${commonViewModel.userName.value}"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                },
                actions = {
                    Text(
                        text = "Reps: ${commonViewModel.repsNumber.value}",
                        fontSize = 20.sp,
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(visible = onClickButton) {
                LaunchedEffect(key1 = true) {
                    coroutineScope.launch {
                        for (i in 0..7) {
                            ExerciseGif(exerciseImage = listOfGifs[i]!!)
                            delay(seconds)
                        }
                    }
                }
            }
            Button(
                onClick = {
                    val
                    onClickButton = !onClickButton
                        coroutineScope.launch {
                            for (i in 0..2){

                                Text("")
                            }
                        }
                }
            ) {
                Text(text = "Comenzar entrenamiento")
            }
            Spacer(
                modifier = Modifier
                .padding(8.dp)
            )
        }
    }
}

@Composable
fun ExerciseGif(exerciseImage: Int) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(context)
                .data(data = exerciseImage)
                .build(),
            imageLoader = imageLoader
        ),
        contentDescription = "Exercise",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}