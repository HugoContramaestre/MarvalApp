package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Image as ImageDomain


data class Image(

    @SerializedName("path") var path: String? = null,
    @SerializedName("extension") var extension: String? = null

){
  fun toDomain() = ImageDomain(
    path,
    extension
  )
}