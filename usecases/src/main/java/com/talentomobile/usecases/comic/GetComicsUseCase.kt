package com.talentomobile.usecases.comic

import com.talentomobile.data.repository.MainRepository

class GetComicsUseCase(private val repository: MainRepository) {
    suspend fun invoke() = repository.getComics()
}