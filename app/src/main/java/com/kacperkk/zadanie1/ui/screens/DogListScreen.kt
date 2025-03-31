package com.kacperkk.zadanie1.ui.screens

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kacperkk.zadanie1.data.model.Dog
import com.kacperkk.zadanie1.ui.components.DogItem
import com.kacperkk.zadanie1.ui.components.SearchBar
import android.util.Log


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogListScreen() {
    // Tutaj normalnie dane mogłyby być pobierane z ViewModelu.
    // Dla przykładu: val dogs by viewModel.dogs.collectAsState()
    var dogs by remember {
        mutableStateOf(
            listOf(
                Dog(id = 1, name = "Pan Pumpernikiel", breed = "Jack Russel"),
                Dog(id = 2, name = "Pan Pumpernikiel", breed = "Jack Russel"),
                Dog(id = 3, name = "Pan Pumpernikiel", breed = "Jack Russel"),
                Dog(id = 4, name = "Pan Pumpernikiel", breed = "Jack Russel"),
            )
        )
    }

    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Doggos", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                navigationIcon = {
                    val onProfileClick: () -> Unit = { Log.d("Profile", "Profile clicked") }

                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                actions = {
                    val onProfileClick: () -> Unit = { Log.d("Profile", "Profile clicked") }

                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Obsługa dodawania nowego psa
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_input_add),
                    contentDescription = "Add Dog"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChange = { query ->
                    searchQuery = query
                    // Ewentualna obsługa filtrowania listy
                },
                placeholderText = "Poszukaj lub dodaj pieska 🐕",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            LazyColumn {
                items(dogs.size) { dog ->
                    DogItem(
                        dog = dogs[dog],
                        onFavoriteClick = { clickedDog ->
                            dogs = dogs.map {
                                if (it.id == clickedDog.id) {
                                    it.copy(isFavorite = !it.isFavorite)
                                } else it
                            }
                        },
                        onDeleteClick = { clickedDog ->
                            dogs = dogs.filter { it.id != clickedDog.id }
                        }
                    )
                }
            }
        }
    }
}