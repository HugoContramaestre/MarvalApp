package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.SeriesSummary as SeriesSummaryDomain

data class SeriesSummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
) {
    fun toDomain() = SeriesSummaryDomain(
        resourceUri,
        name
    )
}
