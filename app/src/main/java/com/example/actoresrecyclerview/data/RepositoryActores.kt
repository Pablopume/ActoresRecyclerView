package com.example.actoresrecyclerview.data

import com.example.actoresrecyclerview.domain.modelo.Actores
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import java.io.InputStream

class RepositoryActores(file: InputStream? = null) {

    companion object{
        private val lista = mutableListOf<Actores>()

    }


    init {
        if (lista.size == 0)
        {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
            val listOfCardsType = Types.newParameterizedType(
                MutableList::class.java,
                Actores::class.java
            )
            val ejemplo = file?.bufferedReader()?.readText()?.let { contenidoFichero ->
                moshi.adapter<List<Actores>>(listOfCardsType)
                    .fromJson(contenidoFichero)
            }

            ejemplo?.let { lista.addAll(it) }
        }
    }
    fun deshabilitarIzquierda(actor: Actores): Boolean {
        return lista.indexOf(actor) == 0
    }

    fun deshabilitarDerecha(actor: Actores): Boolean {
        return lista.indexOf(actor) + 1 == lista.size
    }
    fun getListaActores(): List<Actores> {
        return lista
    }
    fun getActorId(id: Int): Actores {
        return lista.firstOrNull { it.id == id } ?: lista[0]
    }

    fun addActor(actor: Actores) = lista.add(actor)

    fun deleteActor(actor: Actores) = lista.remove(actor)

    fun updateActores(actorAntiguo: Actores, actorActualizado: Actores) {
        lista[lista.indexOf(actorAntiguo)] = actorActualizado
    }

    fun listEmpty(): Boolean {
        return lista.isEmpty()
    }

    fun hayRepetidos(actor: Actores): Boolean {
        return lista.contains(actor)
    }

    fun getActorAnterior(actor: Actores): Actores {

        val actor2: Actores = if ((lista.indexOf(actor) - 1 >= 0))
            lista[lista.indexOf(actor) - 1]
        else {
            actor
        }
        return actor2
    }

    fun getActorSiguiente(actor: Actores): Actores {
        val actor2: Actores = if ((lista.indexOf(actor) + 1 <= lista.size - 1))
            lista[lista.indexOf(actor) + 1]
        else {
            actor
        }
        return actor2
    }
}