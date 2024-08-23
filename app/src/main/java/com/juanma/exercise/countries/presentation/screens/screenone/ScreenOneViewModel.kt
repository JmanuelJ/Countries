package com.juanma.exercise.countries.presentation.screens.screenone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanma.exercise.countries.data.modelo.ApiResponseItem
import com.juanma.exercise.countries.domain.model.Response
import com.juanma.exercise.countries.domain.usecases.UsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenOneViewModel @Inject constructor(
    private val usesCases: UsesCases
) : ViewModel() {

    private val _state = MutableStateFlow(ScreenOneState())
    val state: StateFlow<ScreenOneState> = _state.asStateFlow()

    init {
        getAllCountries()
    }

    fun getAllCountries() = viewModelScope.launch {
        _state.update {
            it.copy(
                response = Response.Loading
            )
        }

        val response = usesCases.getAllCountriesUseCase.invoke()

        _state.update {
            it.copy(
                response = response
            )
        }
    }

    fun onListVideo(countries: ArrayList<ApiResponseItem>) {
        _state.update {
            it.copy(
                countries = countries
            )
        }
    }

    fun onTextInput(text: String) {
        _state.update {

            it.copy(
                textField = text
            )
        }
    }
}