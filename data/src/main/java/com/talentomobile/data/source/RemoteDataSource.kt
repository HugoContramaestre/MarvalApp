package com.talentomobile.data.source

import com.talentomobile.data.exception.Failure
import com.talentomobile.data.functional.Either
import com.talentomobile.domain.characters.CharacterDataWrapper
import com.talentomobile.domain.common.ComicDataWrapper

interface RemoteDataSource {
    suspend fun getCharacters(): Either<Failure, CharacterDataWrapper>
    suspend fun getCharacter(id: Int): Either<Failure, CharacterDataWrapper>
    suspend fun getComics(): Either<Failure, ComicDataWrapper>
    suspend fun getComic(id: Int): Either<Failure, ComicDataWrapper>
}