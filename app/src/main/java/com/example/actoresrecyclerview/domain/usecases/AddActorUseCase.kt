package com.example.actoresapp.domain.usecases


import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores

class AddActorUseCase {
    fun addActor(actor: Actores) = RepositoryActores().addActor(actor)
    fun hayRepetidos(actor: Actores) = RepositoryActores().hayRepetidos(actor)
}