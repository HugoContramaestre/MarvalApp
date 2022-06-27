package com.talentomobile.marvel.data.api

import com.haroldadmin.cnradapter.NetworkResponse
import com.talentomobile.marvel.data.api.response.*
import com.talentomobile.marvel.data.api.response.comics.ComicDataContainer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {


    @GET("public/characters")
    suspend fun getCharacters(
        @Query("ts") timeStamp: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String,
    ): NetworkResponse<CharacterDataWrapper,ErrorResult>

    @GET("public/characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") charId: String,
        @Query("ts") timeStamp: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String
    ): NetworkResponse<CharacterDataWrapper, ErrorResult>

    @GET("public/comics")
    suspend fun getComics(
        @Query("ts") timeStamp: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String,
    ): NetworkResponse<ComicDataWrapper, ErrorResult>

    @GET("public/comics/{comicId}")
    suspend fun getComic(
        @Path("comicId") comicId: String,
        @Query("ts") timeStamp: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String
    ): NetworkResponse<ComicDataWrapper, ErrorResult>

}