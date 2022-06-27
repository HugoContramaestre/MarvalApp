package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.CollectedIssues as CollectedIssuesDomain


data class CollectedIssues(

    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null

){
    fun toDomain() = CollectedIssuesDomain(
        resourceURI,
        name
    )
}