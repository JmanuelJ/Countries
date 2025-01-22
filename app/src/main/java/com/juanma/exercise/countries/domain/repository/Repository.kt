package com.juanma.exercise.countries.domain.repository

import com.juanma.exercise.countries.core.Result
import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem

interface Repository {

    suspend fun getAllCountries(): Result<ArrayList<ResponseCountryItem>>

    suspend fun getCountry(name: String): Result<ArrayList<ResponseApi>>
}