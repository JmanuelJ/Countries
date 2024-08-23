package com.juanma.exercise.countries.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.juanma.exercise.countries.presentation.screens.screenone.ScreenOne
import com.juanma.exercise.countries.presentation.screens.screenone.ScreenOneViewModel
import com.juanma.exercise.countries.presentation.screens.screentwo.ScreenTwo
import com.juanma.exercise.countries.presentation.screens.screentwo.ScreenTwoViewModel

@Composable
fun RootGraph(
    navController: NavHostController,
    screenOneViewModel: ScreenOneViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ScreenOne.route,
        route = Graph.ROOT
    ) {
        composable(route = Screens.ScreenOne.route) {
            ScreenOne(navController = navController, viewModel = screenOneViewModel)
        }

        composable(
            route = Screens.ScreenTwo.route,
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
            })
        ) {
            val screenTwoViewModel: ScreenTwoViewModel = hiltViewModel()
            it.arguments?.getString("name")?.let {
                ScreenTwo(navController = navController, viewModel = screenTwoViewModel, name = it)
            }
        }
    }

}


