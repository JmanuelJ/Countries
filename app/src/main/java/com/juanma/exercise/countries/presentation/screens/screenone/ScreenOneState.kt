package com.juanma.exercise.countries.presentation.screens.screenone

import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem

data class ScreenOneState(
    val countries: ArrayList<ResponseCountryItem>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val textField: String = ""
)