package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.marvel.data.api.response.comics.CharacterSummary
import com.talentomobile.domain.common.CharacterList as CharactersDomain


data class CharacterList(

    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionURI: String? = null,
    @SerializedName("items") var items: List<CharacterSummary> = emptyList()

) {
    fun toDomain() = CharactersDomain(
        available,
        returned,
        collectionURI,
        items.map { it.toDomain() }
    )
}