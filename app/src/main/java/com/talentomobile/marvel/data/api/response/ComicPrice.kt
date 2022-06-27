package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.comics.ComicPrice as ComicPriceDomain


data class ComicPrice(

    @SerializedName("type") var type: String? = null,
    @SerializedName("price") var price: String? = null

){
  fun toDomain() = ComicPriceDomain(
    type,
    price
  )
}