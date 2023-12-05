package com.sergimarrahy.screens

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergimarrahy.sergilist.Model.WowCharacter
import com.sergimarrahy.sergilist.ViewModel.WowCharacterViewModel

@Composable
fun WowCharacterInfo(
    navController: NavController,
    wowCharacterViewModel: WowCharacterViewModel
) {
    val wowCharacter: WowCharacter by wowCharacterViewModel.selectedWowCharacter.observeAsState(WowCharacter())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver"
            )
            Text(
                text = "Volver"
            )
        }

        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = wowCharacter.characterClass,
                fontSize = 30.sp
            )
            Spacer(
                modifier = Modifier
                    .padding(start = 10.dp)
            )

            val icon = if(!wowCharacterViewModel.selectedWowCharacter.value?.favorite!!) {
                Icons.Default.StarBorder
            } else {
                Icons.Default.Star
            }
            Icon(
                imageVector = icon,
                contentDescription = "Estrella",
                modifier = Modifier
                    .clickable {
                        wowCharacterViewModel.onFavoriteClicked()
                        Log.i("", "Estrella rellena: ${wowCharacterViewModel.selectedWowCharacter.value?.favorite}")
                    }
            )
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = wowCharacter.specialization,
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(8.dp)
        ) {
            Text(
                text = "Aquí se mostrará la información detallada de un personaje del wow",
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}