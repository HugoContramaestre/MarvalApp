package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.CharacterDataContainer as CharacterDataContainerDomain


data class CharacterDataContainer(

    @SerializedName("offset") var offset: String? = null,
    @SerializedName("limit") var limit: String? = null,
    @SerializedName("total") var total: String? = null,
    @SerializedName("count") var count: String? = null,
    @SerializedName("results") var results: List<Character> = emptyList()

) {
    fun toDomain() = CharacterDataContainerDomain(
        offset = offset,
        limit = limit,
        total = total,
        count = count,
        results = results.map { it.toDomain() }.filter { it.id != -1 }
    )
}