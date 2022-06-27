package com.talentomobile.marvel.data.api.response.comics

import com.google.gson.annotations.SerializedName
import java.util.*
import com.talentomobile.domain.comics.ComicDate as DatesDomain


data class ComicDate(

    @SerializedName("type") var type: String? = null,
    @SerializedName("date") var date: String? = null

){
    fun toDomain() = DatesDomain(
        type,
        date
    )
}