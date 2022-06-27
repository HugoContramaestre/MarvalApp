package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Variants as VariantsDomain


data class Variants(

    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null

){
  fun toDomain() = VariantsDomain(
    resourceUri,
    name
  )
}