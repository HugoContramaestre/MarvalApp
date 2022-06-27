package com.talentomobile.marvel.data.api

import com.haroldadmin.cnradapter.NetworkResponse
import com.talentomobile.data.exception.Failure
import com.talentomobile.data.functional.Either
import com.talentomobile.data.source.RemoteDataSource
import com.talentomobile.domain.characters.CharacterDataWrapper
import com.talentomobile.domain.common.ComicDataWrapper
import com.talentomobile.marvel.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class ApiRemoteDataSource(private val api: ApiServices) : RemoteDataSource {

    private fun md5(timeStamp: String): String {
        val inputHash = timeStamp + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(inputHash.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }

    override suspend fun getCharacters(): Either<Failure, CharacterDataWrapper> {
        val ts = Date().time.toString()
        return api.getCharacters(
            ts,
            BuildConfig.PUBLIC_KEY,
            md5(ts)
        ).wrapperResponse { i -> i.toDomain() }
    }

    override suspend fun getCharacter(id: Int): Either<Failure, CharacterDataWrapper> {
        val ts = Date().time.toString()
        return api.getCharacter(
            id.toString(),
            ts,
            BuildConfig.PUBLIC_KEY,
            md5(ts)
        ).wrapperResponse { it.toDomain() }
    }

    override suspend fun getComics(): Either<Failure, ComicDataWrapper> {
        val ts = Date().time.toString()
        return api.getComics(
            ts,
            BuildConfig.PUBLIC_KEY,
            md5(ts)
        ).wrapperResponse { i -> i.toDomain() }
    }

    override suspend fun getComic(id: Int): Either<Failure, ComicDataWrapper> {
        val ts = Date().time.toString()
        return api.getComic(
            id.toString(),
            ts,
            BuildConfig.PUBLIC_KEY,
            md5(ts)
        ).wrapperResponse { it.toDomain() }
    }

}

inline fun <In : Any, Out : Any> NetworkResponse<In, ErrorResult>.wrapperResponse(
    transform: ((In) -> Out)
): Either<Failure, Out> {
    return when (this) {
        is NetworkResponse.Success -> Either.Right(transform.invoke(body))
        is NetworkResponse.ServerError -> {
            error?.printStackTrace()
            Either.Left(
                FailureFactory().handleApiCode(
                    code,
                    body
                )
            )
        }
        is NetworkResponse.NetworkError -> {
            error.printStackTrace()
            Either.Left(Failure.NetworkConnection)
        }
        is NetworkResponse.UnknownError -> {
            error.printStackTrace()
            Either.Left(Failure.UnknownApiError)
        }
    }
}

fun <In : Any> NetworkResponse<In, ErrorResult>.wrapperResponseEmpty(): Failure? {
    return when (this) {
        is NetworkResponse.Success -> null
        is NetworkResponse.ServerError ->
            FailureFactory().handleApiCode(
                code,
                body
            )
        else -> Failure.NetworkConnection
    }
}