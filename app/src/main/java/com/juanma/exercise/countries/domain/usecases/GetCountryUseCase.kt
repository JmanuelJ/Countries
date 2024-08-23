package com.juanma.exercise.countries.domain.usecases

import com.juanma.exercise.countries.domain.repository.Repository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String) = repository.getCountry(name)
}