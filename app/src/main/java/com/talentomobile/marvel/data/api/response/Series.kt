package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.SeriesSummary as SeriesDomain


data class Series(

    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null

){
  fun toDomain() = SeriesDomain(
    resourceURI,
    name
  )
}