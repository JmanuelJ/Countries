package com.juanma.exercise.countries.domain.repository

import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.data.modelo.ResponseCountryItem
import com.juanma.exercise.countries.domain.model.Response

interface Repository {

    suspend fun getAllCountries(): Response<ArrayList<ApiResponseItem>>

    suspend fun getCountry(name: String): Response<ArrayList<ResponseCountryItem>>
}