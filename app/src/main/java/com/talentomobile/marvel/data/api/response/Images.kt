package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Images as ImagesDomain


data class Images(

    @SerializedName("path") var path: String? = null,
    @SerializedName("extension") var extension: String? = null

){
  fun toDomain() = ImagesDomain(
    path,
    extension
  )
}