package com.juanma.exercise.countries.presentation.screens.screentwo

import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.domain.model.Response

data class ScreenTwoState(
    var response: Response<ArrayList<ResponseApi>>? = null,
    val info: ArrayList<ResponseApi>? = null
)