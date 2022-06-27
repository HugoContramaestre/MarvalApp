package com.talentomobile.usecases.characters

import com.talentomobile.data.repository.MainRepository

class GetCharacterDetailUseCase(private val repository: MainRepository) {
    suspend fun invoke(id: Int) = repository.getCharacter(id)
}