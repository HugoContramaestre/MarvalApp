package com.talentomobile.usecases.characters

import com.talentomobile.data.repository.MainRepository

class GetCharactersUseCase(private val repository: MainRepository) {
    suspend fun invoke() = repository.getCharacters()
}