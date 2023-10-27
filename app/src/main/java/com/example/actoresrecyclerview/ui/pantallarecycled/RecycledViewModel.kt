package com.example.actoresrecyclerview.ui.pantallarecycled

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.actoresapp.domain.usecases.GetActoresUseCase


class RecycledViewModel(
    private val getActoresUseCase: GetActoresUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData(RecycledState())
    val uiState: LiveData<RecycledState> get() = _uiState
    init {
        _uiState.value = RecycledState(
            lista= getActoresUseCase()
        )
    }

    fun getActores(){
        _uiState.value!!.copy(
            lista = getActoresUseCase()
        )

    }

    class RecycledViewModelFactory(
        private val getActoresUseCase: GetActoresUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
           if (modelClass.isAssignableFrom(RecycledViewModel::class.java)) {
               @Suppress("UNCHECKED_CAST")
                return RecycledViewModel(getActoresUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}