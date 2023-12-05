package com.sergimarrahy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergimarrahy.Route.Routes
import com.sergimarrahy.sergilist.Model.WowCharacter
import com.sergimarrahy.sergilist.ViewModel.WowCharacterViewModel

@Composable
fun MainScreen(
    navController: NavController,
    wowCharacterViewModel: WowCharacterViewModel
) {
    val wowCharacters: List<WowCharacter> by wowCharacterViewModel.wowCharacters.observeAsState(initial = emptyList())
    val isLoadingWowCharacters: Boolean by wowCharacterViewModel.isLoading.observeAsState(initial = false)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 8.dp)
    ) {
        items(wowCharacters) { wowCharacter ->
            WowCharacterCard(wowCharacter = wowCharacter, navController = navController, wowCharacterViewModel = wowCharacterViewModel)
        }
    }

    if (isLoadingWowCharacters) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Loading...",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WowCharacterCard(
    wowCharacter: WowCharacter,
    navController: NavController,
    wowCharacterViewModel: WowCharacterViewModel
) {
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                wowCharacterViewModel.onWowCharacterClicked(wowCharacter)
                navController.navigate(Routes.WowCharacterInfo.route)
            }
    ) {
        ListItem(
            headlineText = {
                Text(
                    text = wowCharacter.characterClass
                )
            },
            supportingText = {
                Text(
                    text = wowCharacter.specialization
                )
            },
            trailingContent = {
                val icon = if (!wowCharacterViewModel.selectedWowCharacter.value?.favorite!!) {
                    Icons.Default.StarBorder
                } else {
                    Icons.Default.Star
                }
                Icon(
                    imageVector = icon,
                    contentDescription = "Estrella"
                )
            }
        )
    }
}
