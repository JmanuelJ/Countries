package com.juanma.exercise.countries.presentation.screens.screentwo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.juanma.exercise.countries.presentation.components.TextDescription

@Composable
fun ViewCountry(
    flag: String,
    common: String,
    official: String,
    capital: String,
    continent: String,
    coat: String,
    url: String
) {
    val localUri = LocalUriHandler.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Información: ",
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 25.sp
            )
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
                TextDescription(text = "Nombre Oficial:  ")
                TextDescription(text = official)
            }
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
                TextDescription(text = "Capital:  ")
                TextDescription(text = capital)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextDescription(text = "Continente:  ")
                TextDescription(text = continent)
            }

            if (coat == "0") {
                TextDescription(text = "Escudo de armas:  ")
                TextDescription(text = "No tiene")
            } else {
                AsyncImage(
                    model = coat,
                    contentDescription = "Flag Country",
                    modifier = Modifier
                        .height(150.dp)
                        .width(300.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.FillBounds,
                )
            }
            Button(
                onClick = {
                    localUri.openUri(url)
                }
            ) {
                Text(text = "Ver mapa")
            }
        }
    }
}

