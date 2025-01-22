package com.juanma.exercise.countries.presentation.screens.screenone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanma.exercise.countries.core.Result
import com.juanma.exercise.countries.domain.usecases.UsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private fun getAllCountries() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            try {
                val response = withContext(Dispatchers.IO){
                    usesCases.getAllCountriesUseCase()
                }

                when(response){
                    is Result.Error -> {
                        _state.update {
                            it.copy(
                                error = response.errorMessage,
                            )
                        }
                    }
                    is Result.Success -> {
                        _state.update {
                            it.copy(
                                countries = response.data
                            )
                        }
                    }
                }

            } catch (e: Exception){
                _state.update {
                    it.copy(
                        error = e.message
                    )
                }
            } finally {
                _state.update {
                    it.copy(
                        isLoading = false
                    )
                }
            }
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