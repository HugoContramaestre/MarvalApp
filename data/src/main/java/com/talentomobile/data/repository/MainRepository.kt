package com.talentomobile.data.repository

import com.talentomobile.data.source.RemoteDataSource

class MainRepository(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getCharacters() = remoteDataSource.getCharacters()

    suspend fun getCharacter(id: Int) = remoteDataSource.getCharacter(id)

    suspend fun getComics() = remoteDataSource.getComics()

    suspend fun getComic(id: Int) = remoteDataSource.getComic(id)
}