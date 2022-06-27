package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.EventSummary as EventSummaryDomain

data class EventSummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
) {
    fun toDomain() = EventSummaryDomain(
        resourceUri,
        name
    )
}
