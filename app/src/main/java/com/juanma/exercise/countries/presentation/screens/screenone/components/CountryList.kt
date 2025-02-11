package com.juanma.exercise.countries.presentation.screens.screenone.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem

@Composable
fun CountyList(
    modifier: Modifier,
    list: ArrayList<ResponseCountryItem>,
    value: String,
    goToScreenTwo: (String?) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list.filter {
            it.name.official.contains(value)
        }) { item ->
            item.apply {
                ItemCountry(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                        .clickable {
                            goToScreenTwo(item.name.common)
                        },
                    flag = item.flags.png,
                    common = item.name.common,
                    official = item.name.official
                )
            }
        }

    }
}