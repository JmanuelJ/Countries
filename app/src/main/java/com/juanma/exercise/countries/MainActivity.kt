package com.juanma.exercise.countries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.juanma.exercise.countries.presentation.navigation.RootGraph
import com.juanma.exercise.countries.presentation.screens.screenone.ScreenOneViewModel
import com.juanma.exercise.countries.presentation.ui.theme.CountriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    private val screenOneViewModel by viewModels<ScreenOneViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            CountriesTheme {
                RootGraph(
                    navController = navHostController,
                    screenOneViewModel =screenOneViewModel,
                )
            }
        }
    }
}