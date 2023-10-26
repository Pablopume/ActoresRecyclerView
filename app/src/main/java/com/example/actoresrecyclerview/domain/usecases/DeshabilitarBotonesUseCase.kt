package com.example.actoresapp.domain.usecases

import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores

class DeshabilitarBotonesUseCase {
    fun deshabilitarIzquierda(actor: Actores) = RepositoryActores().deshabilitarIzquierda(actor)
    fun deshabilitarDerecha(actor: Actores) = RepositoryActores().deshabilitarDerecha(actor)
}