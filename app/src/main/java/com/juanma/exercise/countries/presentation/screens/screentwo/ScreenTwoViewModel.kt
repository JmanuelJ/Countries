package com.juanma.exercise.countries.presentation.screens.screentwo

import androidx.lifecycle.SavedStateHandle
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
class ScreenTwoViewModel @Inject constructor(
    private val usesCases: UsesCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(ScreenTwoState())
    val state: StateFlow<ScreenTwoState> = _state.asStateFlow()
    private val name = savedStateHandle.get<String>("name")

    init {
        getInfo()
    }

    private fun getInfo() {

        viewModelScope.launch {

            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            try {
                name?.let {
                    val response = withContext(Dispatchers.IO) {
                        usesCases.getCountryUseCase(it)
                    }
                    when (response) {
                        is Result.Error -> {
                            _state.update {
                                it.copy(
                                    error = response.errorMessage
                                )
                            }
                        }

                        is Result.Success -> {

                            response.data?.let { country ->
                                _state.update {
                                    it.copy(
                                        response = country
                                    )
                                }
                            }
                        }
                    }
                }

            } catch (e: Exception) {
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
}