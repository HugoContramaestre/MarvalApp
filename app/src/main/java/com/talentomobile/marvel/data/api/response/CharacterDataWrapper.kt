package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.characters.CharacterDataWrapper as CharacterDataWrapperDomain

data class CharacterDataWrapper(

    @SerializedName("code") var code: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("attributionText") var attributionText: String? = null,
    @SerializedName("attributionHTML") var attributionHTML: String? = null,
    @SerializedName("data") var data: CharacterDataContainer? = null,
    @SerializedName("etag") var etag: String? = null

) {
    fun toDomain() = CharacterDataWrapperDomain(
        code = code,
        status = status,
        copyright = copyright,
        attributionText = attributionText,
        attributionHtml = attributionHTML,
        data = data?.toDomain(),
        etag = etag
    )
}