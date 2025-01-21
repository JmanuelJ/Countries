package com.juanma.exercise.countries.data.networking

import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("all?fields=name,flags")
    suspend fun getAllCountries(): ArrayList<ResponseCountryItem>

    @GET("name/{name}")
    suspend fun getCountry(@Path("name") name: String): ArrayList<ResponseApi>
}