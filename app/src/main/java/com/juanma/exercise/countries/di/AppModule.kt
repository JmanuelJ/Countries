package com.juanma.exercise.countries.di

import com.juanma.exercise.countries.data.networking.ApiService
import com.juanma.exercise.countries.data.repository.RepositoryImpl
import com.juanma.exercise.countries.domain.repository.Repository
import com.juanma.exercise.countries.domain.usecases.GetAllCountriesUseCase
import com.juanma.exercise.countries.domain.usecases.GetCountryUseCase
import com.juanma.exercise.countries.domain.usecases.UsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
        return Retrofit
            .Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder)
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