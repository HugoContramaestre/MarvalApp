package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.marvel.data.api.response.comics.ComicDataContainer
import com.talentomobile.domain.common.ComicDataWrapper as ComicDataWrapperDomain


data class ComicDataWrapper(

    @SerializedName("code") var code: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("attributionText") var attributionText: String? = null,
    @SerializedName("attributionHTML") var attributionHtml: String? = null,
    @SerializedName("data") var data: ComicDataContainer? = ComicDataContainer(),
    @SerializedName("etag") var etag: String? = null

){
    fun toDomain() = ComicDataWrapperDomain(
        code,
        status,
        copyright,
        attributionText,
        attributionHtml,
        data?.toDomain(),
        etag
    )
}