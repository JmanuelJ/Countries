package com.juanma.exercise.countries.presentation.screens.screenone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juanma.exercise.countries.presentation.components.TextDescription

@Composable
fun ItemCountry(
    modifier: Modifier,
    flag: String,
    common: String,
    official: String
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = flag,
                contentDescription = "Flag Country",
                modifier = Modifier
                    .height(150.dp)
                    .width(300.dp)
                    .padding(8.dp),
                contentScale = ContentScale.FillBounds,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextDescription(text = "Nombre común:  ")
                TextDescription(text = common)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextDescription(text = "Nombre Oficial:  ")
                TextDescription(text = official)
            }
        }
    }
}


