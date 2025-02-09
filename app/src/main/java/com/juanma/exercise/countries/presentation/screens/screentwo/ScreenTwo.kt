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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanma.exercise.countries.presentation.common.ProgressBar
import com.juanma.exercise.countries.presentation.screens.screentwo.components.ViewCountry
import com.juanma.exercise.countries.presentation.ui.theme.Black

@Composable
fun ScreenTwo(
    navController: NavController,
    viewModel: ScreenTwoViewModel,
    nameCountry: String
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.getInfo(nameCountry = nameCountry)
        Toast.makeText(context, "hol", Toast.LENGTH_SHORT)
            .show()
    }

    if (state.error != null) {
        Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_SHORT)
            .show()
    }

    if (state.isLoading) {
        ProgressBar()
    }

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

        state.response?.get(0).let {
            it?.apply {
                ViewCountry(
                    flag = flags.png,
                    common = name.common,
                    official = name.official,
                    capital = capital.toString(),
                    continent = continents.toString(),
                    coat = if (coatOfArms.png == null) "0" else coatOfArms.png,
                    url = maps.googleMaps
                )
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
