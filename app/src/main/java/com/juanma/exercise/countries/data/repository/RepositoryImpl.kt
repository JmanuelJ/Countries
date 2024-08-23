package com.juanma.exercise.countries.data.repository

import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.data.modelo.ResponseCountryItem
import com.juanma.exercise.countries.data.remote.ApiService
import com.juanma.exercise.countries.domain.model.Response
import com.juanma.exercise.countries.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: ApiService
): Repository{
    override suspend fun getAllCountries(): Response<ArrayList<ApiResponseItem>> {
        return try{
            val response = service.getAllCountries()
            Response.Success(response)
        } catch (e: Exception){
            e.printStackTrace()
            Response.Error(e.message ?: "Error en servicio")
        }
    }

    override suspend fun getCountry(name: String): Response<ArrayList<ResponseCountryItem>> {
        return try {
            val response = service.getCountry(name)
            Response.Success(response)
        } catch (e: Exception){
            e.printStackTrace()
            Response.Error(e.message ?: "Error de servicio")
        }
    }

}