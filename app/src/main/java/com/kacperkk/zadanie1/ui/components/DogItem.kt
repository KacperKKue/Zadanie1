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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
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
                style = MaterialTheme.typography.labelSmall,
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
                painter = painterResource(
                    id = if (dog.isFavorite) {
                        R.drawable.btn_star_big_on
                    } else {
                        R.drawable.btn_star_big_off
                    }
                ),
                contentDescription = "Favorite"
            )
        }

        // Przycisk usunięcia
        IconButton(
            onClick = { onDeleteClick(dog) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_delete),
                contentDescription = "Delete"
            )
        }
    }
}