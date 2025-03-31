package com.kacperkk.zadanie1.ui.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kacperkk.zadanie1.data.model.Dog


@Composable
fun DogItem(
    dog: Dog,
    onFavoriteClick: (Dog) -> Unit,
    onDeleteClick: (Dog) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Ikonka placeholdera psa (zamiast zdjęcia)
        // https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(
                    Brush.linearGradient(
                        // #65558F, #EEB6E8F0, convert to rgb: 101, 85, 143, 238, 184, 224
                        colors = listOf(Color(101, 85, 143), Color(238, 184, 224))
                    )
                )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            // Nazwa psa
            Text(
                text = dog.name,
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            // Rasa psa
            Text(
                text = dog.breed,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Przycisk polubienia
        IconButton(
            onClick = { onFavoriteClick(dog) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = if (dog.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Favorite"
            )
        }

        // Przycisk usunięcia
        IconButton(
            onClick = { onDeleteClick(dog) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Delete"
            )
        }
    }
}