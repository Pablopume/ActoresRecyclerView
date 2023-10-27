package com.example.actoresrecyclerview.domain.modelo

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
@JsonClass(generateAdapter = true)
@Parcelize
data class Actores(
    @Json(name="id")
    var id: Int= 0,
    @Json (name="nombre")
    val nombre: String = "",
    @Json (name="activo")
    val vivo: Boolean = true,
    @Json(name="pelicula")
    val peliculaFamosa: String = "",
    @Json (name="rating")
    val premiosOscar: Int = 0,
    @Json(name="genero")
    val genero: String = ""
) : Parcelable