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
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.viewmodel.MainScreenViewModel

//@Composable
//fun SeriesScreen(navController: NavHostController) {
//    val series: Series by mainScreenViewModel.selectedSeries.observeAsState(Series())
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colorScheme.primaryContainer)
//            .padding(8.dp)
//    ) {
//        Row(
//            modifier = Modifier.clickable {
//                navController.popBackStack()
//            }
//        ) {
//            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Flecha atrás")
//            Text(text = "Volver")
//        }
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(imageVector = Icons.Default.BubbleChart, contentDescription = "Series")
//        Spacer(modifier = Modifier.width(20.dp))
//        Text(text = series.name, fontSize = 16.sp)
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//    Row(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.secondaryContainer)
//    ) {
//        Text(
//            text = series.description,
//            color = MaterialTheme.colorScheme.onTertiary
//        )
//    }
//}