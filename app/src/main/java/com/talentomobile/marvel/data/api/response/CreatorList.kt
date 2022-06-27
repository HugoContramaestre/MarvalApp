package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.marvel.data.api.response.comics.CreatorSummary
import com.talentomobile.domain.comics.CreatorList as CreatorsDomain


data class CreatorList(

    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionURI: String? = null,
    @SerializedName("items") var items: List<CreatorSummary> = emptyList()

){
  fun toDomain() = CreatorsDomain(
    available,
    returned,
    collectionURI,
    items.map { it.toDomain() }
  )
}