package com.juanma.exercise.countries.domain.repository

import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem
import com.juanma.exercise.countries.domain.model.Response

interface Repository {

    suspend fun getAllCountries(): Response<ArrayList<ResponseCountryItem>>

    suspend fun getCountry(name: String): Response<ArrayList<ResponseApi>>
}