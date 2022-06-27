package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.EventList as EventsDomain


data class EventList(

    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionUri: String? = null,
    @SerializedName("items") var items: List<EventSummary> = emptyList()

) {
    fun toDomain() = EventsDomain(
        available,
        returned,
        collectionUri,
        items.map { it.toDomain() }
    )
}