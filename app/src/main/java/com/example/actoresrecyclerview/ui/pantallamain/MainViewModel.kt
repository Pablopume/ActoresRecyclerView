package com.example.actoresrecyclerview.ui.pantallamain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.actoresrecyclerview.domain.usecases.AddActorUseCase
import com.example.actoresrecyclerview.domain.usecases.DeleteActorUseCase
import com.example.actoresapp.domain.usecases.GetActorIdUseCase
import com.example.actoresapp.domain.usecases.GetActoresUseCase
import com.example.actoresapp.domain.usecases.UpdateActorUseCase
import com.example.actoresapp.utils.StringProvider
import com.example.actoresrecyclerview.domain.modelo.Actores
import com.example.recyclerview.R

class MainViewModel(private val addActoruseCase: AddActorUseCase,
                    private val deleteActorUseCase: DeleteActorUseCase,
                    private val getActoresUseCase: GetActoresUseCase,
                    private val getActorIdUseCase: GetActorIdUseCase,
                    private val updateActorUseCase: UpdateActorUseCase,
                    private val stringProvider: StringProvider

                    ) : ViewModel(){

    private val _uiState = MutableLiveData(MainState())
    val uiState: LiveData<MainState> get() = _uiState

    init {
        _uiState.value = MainState(

            actores = _uiState.value.let { getActorIdUseCase(2) },
            error = null
        )
    }

    fun getActor(id: Int){
        _uiState.value=MainState(actores = getActorIdUseCase(id))
    }

    fun deleteActor() {
        val actores = _uiState.value?.actores
        if (actores != null && !deleteActorUseCase.deleteActor(actores)) {
            _uiState.value = MainState(
                error = stringProvider.getString(R.string.app_name)
            )
        } else {
            if (deleteActorUseCase.listEmpty()) {
                _uiState.value = MainState(actores = Actores())
            }
        }
    }



    fun addActor(actor: Actores) {
        val actores = _uiState.value?.actores
        if (!addActoruseCase.hayRepetidos(actor)) {
            if (!addActoruseCase.addActor(actor)) {
                if (actores != null) {
                    _uiState.value = MainState(
                        actores = actores,
                        error = stringProvider.getString(R.string.repetido)
                    )
                }
            } else {
                _uiState.value = MainState(actores = actor, error = null)
            }
        } else {
            if (actores != null) {
                _uiState.value = MainState(
                    actores = actores,
                    error = stringProvider.getString(R.string.repetido)
                )
            }
        }
    }



    fun errorMostrado() {
        _uiState.value = MainState(error = null, actores = _uiState.value?.actores!!)
    }

    fun updateActor(actor: Actores) {
        val actores = _uiState.value?.actores
        if (actores != null) {
            updateActorUseCase(actores, actor)
        }
        _uiState.value = MainState(actores = actor)
    }


}

class MainViewModelFactory(
    private val addActoruseCase: AddActorUseCase,
    private val deleteActorUseCase: DeleteActorUseCase,
    private val getActoresUseCase: GetActoresUseCase,
    private val getActorIdUseCase: GetActorIdUseCase,
    private val updateActorUseCase: UpdateActorUseCase,
    private val stringProvider: StringProvider,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                addActoruseCase,
                deleteActorUseCase,
                getActoresUseCase,
                getActorIdUseCase,
                updateActorUseCase,
                stringProvider,

                ) as T
        }
        throw IllegalArgumentException(Constantes.UNKNOWN_VIEW_MODEL_CLASS)
    }
}
