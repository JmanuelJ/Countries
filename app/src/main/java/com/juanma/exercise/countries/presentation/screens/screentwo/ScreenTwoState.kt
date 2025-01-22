package com.juanma.exercise.countries.presentation.screens.screentwo

import com.juanma.exercise.countries.data.networking.model.ResponseApi

data class ScreenTwoState(
    var response: ArrayList<ResponseApi>? = null,
    val error: String? = null,
    val isLoading: Boolean = false
)