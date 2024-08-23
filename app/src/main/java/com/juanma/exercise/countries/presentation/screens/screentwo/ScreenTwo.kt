package com.juanma.exercise.countries.presentation.screens.screentwo

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanma.exercise.countries.domain.model.Response
import com.juanma.exercise.countries.presentation.components.ProgressBar
import com.juanma.exercise.countries.presentation.screens.screentwo.components.ViewCountry
import com.juanma.exercise.countries.presentation.ui.theme.Black

@Composable
fun ScreenTwo(
    navController: NavController,
    viewModel: ScreenTwoViewModel,
    name: String
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        DefaultButton(
            modifier = Modifier
                .size(60.dp)
                .clickable {
                    navController.popBackStack()
                }
                .padding(top = 16.dp)
                .align(alignment = Alignment.Start)
        )
        when (val response = state.response) {
            is Response.Error -> {
                Toast.makeText(LocalContext.current, response.errorMessage, Toast.LENGTH_SHORT)
                    .show()
            }

            Response.Loading -> {
                ProgressBar()
            }

            is Response.Success -> {
                viewModel.onList(response.data)
                state.info?.get(0)?.let {
                    ViewCountry(
                        flag = it.flags.png,
                        common = it.name.common,
                        official =it.name.official,
                        capital = it.capital.toString(),
                        continent = it.continents.toString(),
                        coat = if (it.coatOfArms.png == null) "0" else it.coatOfArms.png,
                        url = it.maps.googleMaps
                    )
                }
            }

            null -> {
            }
        }

        
    }
}


@Composable
fun DefaultButton(
    modifier: Modifier,
) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "Back",
        modifier = modifier,
        tint = Black
    )
}
