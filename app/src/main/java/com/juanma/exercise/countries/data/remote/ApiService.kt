package com.juanma.exercise.countries.data.remote

import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.data.modelo.ResponseCountryItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("all?fields=name,flags")
    suspend fun getAllCountries(): ArrayList<ApiResponseItem>

    @GET("name/{name}")
    suspend fun getCountry(@Path("name") name: String): ArrayList<ResponseCountryItem>
}