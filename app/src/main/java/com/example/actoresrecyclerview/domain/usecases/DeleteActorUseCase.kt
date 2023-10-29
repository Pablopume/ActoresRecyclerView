package com.example.actoresrecyclerview.domain.usecases


import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores

class DeleteActorUseCase {
    fun deleteActor(actor: Actores) = RepositoryActores().deleteActor(actor)
    fun listEmpty() = RepositoryActores().listEmpty()
}