package com.talentomobile.marvel.data.api.response.comics

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.comics.CreatorSummary as CreatorSummaryDomain

data class CreatorSummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("role") var role: String? = null,
) {
    fun toDomain() = CreatorSummaryDomain(
        resourceUri,
        name,
        role
    )
}
