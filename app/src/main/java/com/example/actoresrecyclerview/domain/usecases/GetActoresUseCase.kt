package com.example.actoresapp.domain.usecases


import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores

class GetActoresUseCase (var repositoryActores: RepositoryActores){
    operator fun invoke() = repositoryActores.getListaActores()

}