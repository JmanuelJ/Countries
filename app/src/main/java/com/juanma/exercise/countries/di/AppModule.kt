package com.juanma.exercise.countries.di

import com.juanma.exercise.countries.data.remote.ApiService
import com.juanma.exercise.countries.data.repository.RepositoryImpl
import com.juanma.exercise.countries.domain.repository.Repository
import com.juanma.exercise.countries.domain.usecases.GetAllCountriesUseCase
import com.juanma.exercise.countries.domain.usecases.GetCountryUseCase
import com.juanma.exercise.countries.domain.usecases.UsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository = impl

    @Provides
    fun provideUseCases(repository: Repository) = UsesCases(
        getAllCountriesUseCase = GetAllCountriesUseCase(repository),
        getCountryUseCase = GetCountryUseCase(repository)
    )
}