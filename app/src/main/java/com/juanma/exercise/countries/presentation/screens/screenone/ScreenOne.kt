package com.juanma.exercise.countries.presentation.screens.screenone

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanma.exercise.countries.presentation.components.ProgressBar
import com.juanma.exercise.countries.presentation.screens.screenone.components.CountyList
import com.juanma.exercise.countries.presentation.screens.screenone.components.SearchBar
import com.juanma.exercise.countries.presentation.ui.theme.White

@Composable
fun ScreenOne(
    navController: NavController,
    viewModel: ScreenOneViewModel
) {
    val state by viewModel.state.collectAsState()


    if (state.error != null) {
        Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_SHORT)
            .show()
    }
    if (state.isLoading){
        ProgressBar()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 8.dp)
                .background(color = White, shape = CircleShape),
            value = state.textField,
            onValue = {
                viewModel.onTextInput(it)
            }
        )

        state.countries?.let {
            CountyList(
                modifier = Modifier.fillMaxWidth(),
                list = it,
                value = state.textField,
                navController = navController
            )
        }
    }
}