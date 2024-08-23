package com.juanma.exercise.countries.presentation.screens.screentwo

import com.juanma.exercise.countries.data.modelo.ResponseCountryItem
import com.juanma.exercise.countries.domain.model.Response

data class ScreenTwoState(
    var response: Response<ArrayList<ResponseCountryItem>>? = null,
    val info: ArrayList<ResponseCountryItem>? = null
)