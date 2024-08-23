package com.juanma.exercise.countries.presentation.screens.screentwo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanma.exercise.countries.data.modelo.ResponseCountryItem
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

    private fun getInfo() = viewModelScope.launch {

        _state.update {
            it.copy(
                response = Response.Loading
            )
        }

        val response = usesCases.getCountryUseCase.invoke(name!!)

        _state.update {
            it.copy(
                response = response
            )
        }
    }

    fun onList(info: ArrayList<ResponseCountryItem>) {
        _state.update {
            it.copy(
                info = info
            )
        }
    }

}