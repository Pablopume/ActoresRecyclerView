package com.example.actoresapp.domain.usecases


import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores

class GetActoresUseCase {
    fun invoke() = RepositoryActores().getListaActores()
    fun obtenerActorSiguiente(actor: Actores) = RepositoryActores().getActorSiguiente(actor)
    fun obtenerActorAnterior(actor: Actores) = RepositoryActores().getActorAnterior(actor)
}