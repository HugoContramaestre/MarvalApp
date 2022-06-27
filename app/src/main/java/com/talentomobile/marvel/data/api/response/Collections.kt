package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Collections as CollectionsDomain


data class Collections(

    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null

){
    fun toDomain() = CollectionsDomain(
        resourceURI,
        name
    )
}