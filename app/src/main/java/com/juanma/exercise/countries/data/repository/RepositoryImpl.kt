package com.juanma.exercise.countries.data.repository

import com.juanma.exercise.countries.core.Result
import com.juanma.exercise.countries.data.networking.ApiService
import com.juanma.exercise.countries.data.networking.model.ResponseApi
import com.juanma.exercise.countries.data.networking.model.ResponseCountryItem
import com.juanma.exercise.countries.domain.repository.Repository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: ApiService
) : Repository {
    override suspend fun getAllCountries(): Result<ArrayList<ResponseCountryItem>> {
        return try {
            val response = service.getAllCountries()

            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(response.message())
            }
        }
        catch (e: HttpException){
            Result.Error("¡Error HTTP!")
        }
        catch (e: IOException){
            Result.Error("¡Por favor! Comprueba tu conexión")
        }
        catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun getCountry(name: String): Result<ArrayList<ResponseApi>> {
        return try {
            val response = service.getCountry(name)

            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(response.message())
            }
        }
        catch (e: HttpException){
            Result.Error("¡Error HTTP!")
        }
        catch (e: IOException){
            Result.Error("¡Por favor! Comprueba tu conexión")
        }
        catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

}