package com.example.actoresrecyclerview.ui.pantallamain

import com.example.actoresrecyclerview.domain.modelo.Actores

data class MainState(
    val actores: Actores = Actores(0,Constantes.EMPTY, true,Constantes.EMPTY, 0,Constantes.EMPTY),
    val error: String? = null,
    val botonIzquierda: Boolean? = true,
    val botonDerecha: Boolean? = true
)