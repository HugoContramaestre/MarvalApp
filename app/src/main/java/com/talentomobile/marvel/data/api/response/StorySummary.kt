package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.StorySummary as StorySummaryDomain


data class StorySummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
){
    fun toDomain() = StorySummaryDomain(
        resourceUri,
        name,
        type
    )
}