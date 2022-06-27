package com.talentomobile.marvel.data.api.response.comics

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.comics.CharacterSummary as CharacterSummaryDomain

data class CharacterSummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("role") var role: String? = null,
) {
    fun toDomain() = CharacterSummaryDomain(
        resourceUri,
        name,
        role
    )
}
