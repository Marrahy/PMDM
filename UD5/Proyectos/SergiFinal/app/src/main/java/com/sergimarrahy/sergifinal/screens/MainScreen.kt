package com.sergimarrahy.sergifinal.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.sergifinal.tools.TopCenterAppBarCustom
import com.sergimarrahy.viewmodel.SeriesViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val seriesViewModel = remember {
        SeriesViewModel(context)
    }
    val seriesList by seriesViewModel.seriesList.observeAsState(initial = emptyList())

    Scaffold(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        contentColor = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopCenterAppBarCustom(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.AddScreen.routes)
                },
                containerColor = contentColorFor(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir serie"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Spacer(
                modifier = Modifier
                .padding(8.dp)
            )
            Text(
                text = "Lista de series",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(7.7f)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(seriesList) { series ->
                        SeriesItem(
                            series = series,
                            onDelete = {
                                seriesViewModel.deleteSeries(series)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SeriesItem(
    series: Series,
    onDelete: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(
                text = series.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        leadingContent = {
            Icon(
                imageVector = Icons.Default.BubbleChart,
                contentDescription = "Icono burbujas"
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        trailingContent = {
            IconButton(
                onClick = {
                    onDelete()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete series"
                )
            }
        },
        modifier = Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
    )
}