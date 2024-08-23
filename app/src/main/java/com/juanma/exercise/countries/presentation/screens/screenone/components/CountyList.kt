package com.juanma.exercise.countries.presentation.screens.screenone.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.presentation.navigation.Screens

@Composable
fun CountyList(
    modifier: Modifier,
    list: ArrayList<ApiResponseItem>,
    value: String,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list.filter {
            it.name.official.contains(value)
        }){ item ->
            item.apply {
                ItemCountry(
                    modifier = Modifier.fillMaxWidth().padding(32.dp).clickable {
                        navController.navigate(route = Screens.ScreenTwo.passName(item.name.common))
                    },
                    flag = item.flags.png,
                    common = item.name.common,
                    official = item.name.official
                )
            }
        }

    }
}