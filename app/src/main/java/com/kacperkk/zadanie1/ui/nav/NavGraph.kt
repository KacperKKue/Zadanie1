package com.kacperkk.zadanie1.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kacperkk.zadanie1.ui.screen.DogListScreen
import com.kacperkk.zadanie1.ui.screen.ProfileScreen
import com.kacperkk.zadanie1.ui.screen.SettingsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    onTitleChange: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = "dogList"
    ) {
        composable("dogList") {
            onTitleChange("Doggos")
            DogListScreen()
        }
        composable("profile") {
            onTitleChange("Profile")
            ProfileScreen()
        }
        composable("settings") {
            onTitleChange("Settings")
            SettingsScreen()
        }
    }
}