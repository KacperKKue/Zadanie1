package com.kacperkk.zadanie1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kacperkk.zadanie1.ui.theme.Zadanie1Theme
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kacperkk.zadanie1.ui.components.AppTopBar
import com.kacperkk.zadanie1.ui.screens.DogDetailScreen
import com.kacperkk.zadanie1.ui.screens.DogListScreen
import com.kacperkk.zadanie1.ui.screens.ProfileScreen
import com.kacperkk.zadanie1.ui.screens.SettingsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zadanie1Theme {
                Zadanie1App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Zadanie1App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "dog_list"
    ) {
        composable("dog_list") { DogListScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("dog_detail/{dogId}") { backStackEntry ->
            val dogId = backStackEntry.arguments?.getString("dogId") ?: "Unknown"
            DogDetailScreen(navController, dogId)
        }
    }
}