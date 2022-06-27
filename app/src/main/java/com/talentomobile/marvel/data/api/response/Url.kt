package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Url as UrlDomain


data class Url (

  @SerializedName("type" ) var type : String? = null,
  @SerializedName("url"  ) var url  : String? = null

){
  fun toDomain() = UrlDomain(
    type,
    url
  )
}