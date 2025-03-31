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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kacperkk.zadanie1.ui.theme.Zadanie1Theme
import androidx.compose.ui.text.style.TextAlign
import com.kacperkk.zadanie1.ui.components.AppTopBar
import com.kacperkk.zadanie1.ui.screens.DogListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zadanie1Theme {
                AppTopBar()
                DogListScreen()
            }
        }
    }
}