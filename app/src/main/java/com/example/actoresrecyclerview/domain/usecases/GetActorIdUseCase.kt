package com.example.actoresapp.domain.usecases


import com.example.actoresrecyclerview.data.RepositoryActores

class GetActorIdUseCase {
    operator fun invoke(id: Int) = RepositoryActores().getActorId(id)
}