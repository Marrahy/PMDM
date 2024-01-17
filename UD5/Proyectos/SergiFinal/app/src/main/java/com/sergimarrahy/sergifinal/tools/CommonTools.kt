package com.sergimarrahy.sergifinal.tools

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergimarrahy.sergifinal.R
import com.sergimarrahy.sergifinal.navigation.Routes
import com.sergimarrahy.viewmodel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopCenterAppBarCustom(navController: NavController, mainScreenViewModel: MainScreenViewModel) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Image(
                painter = painterResource(id = R.drawable.cartoon_network_lol),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(horizontal = 100.dp, vertical = 100.dp)
            )
        },
        navigationIcon = {
            CustomDropDownMenu(navController, mainScreenViewModel)
        }
    )
}
@Composable
fun CustomDropDownMenu(navController: NavController, mainScreenViewModel: MainScreenViewModel) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    IconButton(
        onClick = {
            expanded = true
        }
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu"
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            expanded = false
        }
    ) {
        DropdownMenuItem(
            text = {
                Text(text = "Sergi Marrahy Arenas")
            },
            onClick = {

            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.cartoon_network),
                    contentDescription = "Profile photo",
                    modifier = Modifier
                        .size(height = 50.dp, width = 50.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = CircleShape
                        )
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Página principal")
            },
            onClick = {
                navController.navigate(Routes.MainScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Main Screen"
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Agregar")
            },
            onClick = {
                navController.navigate(Routes.AddScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Screen"
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Cerrar Sesión")
            },
            onClick = {
                mainScreenViewModel.deleteUserPreferences()
                navController.navigate(Routes.OnBoardingScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "OnBoarding Screen"
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Autor")
            },
            onClick = {
                navController.navigate(Routes.AuthorScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Author Screen"
                )
            }
        )
    }
}