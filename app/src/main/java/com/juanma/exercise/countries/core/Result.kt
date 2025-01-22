package com.juanma.exercise.countries.core

sealed class Result<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T?) : Result<T>(data = data)
    class Error<T>(errorMessage: String) : Result<T>(errorMessage = errorMessage)
}