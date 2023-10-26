package com.example.actoresrecyclerview.domain.usecases

import com.example.actoresrecyclerview.data.RepositoryActores
import java.io.File
import java.io.InputStream

class GetListaUseCase {

    fun invoke() = RepositoryActores().getListaActores()
}