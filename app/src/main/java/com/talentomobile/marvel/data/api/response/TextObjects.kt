package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.TextObjects as TextObjectsDomain


data class TextObjects (

  @SerializedName("type"     ) var type     : String? = null,
  @SerializedName("language" ) var language : String? = null,
  @SerializedName("text"     ) var text     : String? = null

){
  fun toDomain() = TextObjectsDomain(
    type,
    language,
    text
  )
}