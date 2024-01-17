package com.sergimarrahy.sergifinal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.viewmodel.MainScreenViewModel

@Composable
fun SeriesScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mainScreenViewModel = remember {
        MainScreenViewModel(context)
    }
    val seriesName = mainScreenViewModel.seriesSelected.name
    val seriesDescription = mainScreenViewModel.seriesSelected.description
    val seriesChapter = mainScreenViewModel.seriesSelected.chapterNumber
    val series: Series by mainScreenViewModel.selectedSeries.observeAsState(Series(mainScreenViewModel.seriesSelected.id, seriesName, seriesDescription, seriesChapter))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        Text(
            text = series.name,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = series.description,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}