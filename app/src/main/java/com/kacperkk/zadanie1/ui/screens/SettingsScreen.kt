package com.kacperkk.zadanie1.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Ustawienia", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                navigationIcon = {
                    val onProfileClick: () -> Unit = { navController.navigate("dog_list") }

                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Settings")
                    }
                },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


        }
    }
}