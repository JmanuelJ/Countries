package com.juanma.exercise.countries.presentation.screens.screenone

import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem
import com.juanma.exercise.countries.domain.model.Response

data class ScreenOneState(
    val response: Response<ArrayList<ResponseCountryItem>>? = null,
    val countries: ArrayList<ResponseCountryItem> = ArrayList(),
    val textField: String = ""
)