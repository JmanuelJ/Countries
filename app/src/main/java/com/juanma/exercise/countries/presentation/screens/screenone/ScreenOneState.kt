package com.juanma.exercise.countries.presentation.screens.screenone

import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.domain.model.Response

data class ScreenOneState(
    val response: Response<ArrayList<ApiResponseItem>>? = null,
    val countries: ArrayList<ApiResponseItem> = ArrayList(),
    val textField: String = ""
)