package com.talentomobile.usecases.comic

import com.talentomobile.data.repository.MainRepository

class GetComicDetailUseCase(private val repository: MainRepository) {
    suspend fun invoke(id: Int) = repository.getComic(id)
}